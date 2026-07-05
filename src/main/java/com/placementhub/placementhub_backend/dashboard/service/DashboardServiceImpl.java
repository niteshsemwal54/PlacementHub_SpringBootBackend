package com.placementhub.placementhub_backend.dashboard.service;

import com.placementhub.placementhub_backend.dashboard.dto.*;
import com.placementhub.placementhub_backend.test.entity.TestAttempt;
import com.placementhub.placementhub_backend.test.repository.TestAttemptRepository;
import com.placementhub.placementhub_backend.user.entity.User;
import com.placementhub.placementhub_backend.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final UserRepository userRepository;
    private final TestAttemptRepository testAttemptRepository;

    public DashboardServiceImpl(UserRepository userRepository,
                                TestAttemptRepository testAttemptRepository) {
        this.userRepository = userRepository;
        this.testAttemptRepository = testAttemptRepository;
    }

    @Override
    public DashboardResponse getDashboard(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        /*
         * Compute placement score only when invalid (-1)
         */
        if (user.getPlacementScore() == -1) {

            List<TestAttempt> attempts =
                    testAttemptRepository.findByUserIdOrderBySubmittedAtDesc(user.getId());

            int totalCorrect = 0;
            int totalQuestions = 0;

            for (TestAttempt attempt : attempts) {
                totalCorrect += attempt.getCorrectAnswers();
                totalQuestions += attempt.getTotalQuestions();
            }

            int placementScore = 0;

            if (totalQuestions > 0) {
                placementScore =
                        (int) Math.round((totalCorrect * 100.0) / totalQuestions);
            }

            user.setPlacementScore(placementScore);
            userRepository.save(user);
        }

        DashboardUserDto dashboardUser =
                new DashboardUserDto(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getProfilePicture(),
                        user.getTestsAttempted(),
                        user.getPlacementScore()
                );

        /*
         * Recent Tests
         */
        List<TestAttempt> attempts =
                testAttemptRepository.findTop5ByUserIdOrderBySubmittedAtDesc(user.getId());

        List<RecentTestDto> recentTests = new ArrayList<>();

        for (TestAttempt attempt : attempts) {

            recentTests.add(

                    new RecentTestDto(

                            attempt.getId(),
                            attempt.getTopic(),
                            attempt.getScore(),
                            attempt.getPercentage(),
                            attempt.getSubmittedAt()
                    )
            );
        }

        /*
         * Leaderboard
         */
        List<User> users =
                userRepository.findTop3ByPlacementScoreNotOrderByPlacementScoreDesc(-1);

        List<LeaderboardUserDto> leaderboard = new ArrayList<>();

        for (User u : users) {

            leaderboard.add(

                    new LeaderboardUserDto(

                            u.getId(),
                            u.getName(),
                            u.getProfilePicture(),
                            u.getPlacementScore(),
                            u.getTestsAttempted()
                    )
            );
        }

        return new DashboardResponse(
                dashboardUser,
                recentTests,
                leaderboard
        );
    }
}