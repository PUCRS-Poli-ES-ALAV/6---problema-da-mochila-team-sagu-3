public class EditarDistancia {

    public static void main(String[] args) {
        String s1 = "Casablanca";
        String s2 = "Portentoso";

        int distancia = editDistance(s1, s2);
        System.out.println("Distância de edição: " + distancia);
    }

    public static int editDistance(String s1, String s2) {
        int s1Tam = s1.length();
        int s2Tam = s2.length();
        int[][] dp = new int[s1Tam + 1][s2Tam + 1];
        int iteracoes = 0;

        for (int i = 0; i <= s1Tam; i++) {
            dp[i][0] = i;
            iteracoes++;
        }  

        for (int j = 0; j <= s2Tam; j++) {
            dp[0][j] = j;
            iteracoes++;
        }

        for (int i = 1; i<= s1Tam; i++) {
            for (int j = 1; j <= s2Tam; j++) {
                iteracoes++;
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
        System.out.println("Iterações: " + iteracoes);
        return dp[s1Tam][s2Tam];

    }
}
