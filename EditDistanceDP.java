public class EditDistanceDP {

    public static class Result {
        int distance;
        int iterations;

        public Result(int distance, int iterations) {
            this.distance = distance;
            this.iterations = iterations;
        }
    }

    public static Result editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int iterations = 0;

        // Inicialização
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        // Preenchimento da tabela
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                iterations++;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            Math.min(dp[i - 1][j], dp[i][j - 1]),
                            dp[i - 1][j - 1]
                    );
                }
            }
        }

        return new Result(dp[n][m], iterations);
    }

    public static void main(String[] args) {
        String s1 = "Casablanca";
        String s2 = "Portentoso";

        Result res1 = editDistance(s1, s2);
        System.out.println("Distância de edição (DP): " + res1.distance);
        System.out.println("Iterações: " + res1.iterations);

        String s3 = "Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to " +
                "simplify the build processes in the Jakarta Turbine project. There were several" +
                " projects, each with their own Ant build files, that were all slightly different." +
                "JARs were checked into CVS. We wanted a standard way to build the projects, a clear " +
                "definition of what the project consisted of, an easy way to publish project information" +
                "and a way to share JARs across several projects. The result is a tool that can now be" +
                "used for building and managing any Java-based project. We hope that we have created " +
                "something that will make the day-to-day work of Java developers easier and generally help " +
                "with the comprehension of any Java-based project.";
        String s4 = "This post is not about deep learning. But it could be might as well. This is the power of " +
                "kernels. They are universally applicable in any machine learning algorithm. Why you might" +
                "ask? I am going to try to answer this question in this article." +
                "Go to the profile of Marin Vlastelica Pogančić" +
                "Marin Vlastelica Pogančić Jun";

        Result res2 = editDistance(s3, s4);
        System.out.println("Distância de edição (DP, caso grande): " + res2.distance);
        System.out.println("Iterações: " + res2.iterations);
    }
}
