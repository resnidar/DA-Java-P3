package com.resnidar;

class Games {
    protected boolean devMode = true;

    /**
     * cette fonction permet de comparé les tableaux entres eux
     * @param randomNumberTab tableau de nombre aléatoire
     * @param userTab tableu remplie par l'utilisateur
     * @param fail le nombre de faute
     * @param endGame bool permettant de stoppé le jeu
     * @return
     */
    protected int propositionCompar(char[] randomNumberTab, char[] userTab, int fail, boolean endGame) {
        for (int j = 0; j < randomNumberTab.length; j++) {
            if (randomNumberTab[j] > userTab[j]) {
                System.out.print("+");
                fail++;
            } else if (randomNumberTab[j] == userTab[j])
                System.out.print("=");
            else if (randomNumberTab[j] < userTab[j]) {
                System.out.print("-");
                fail++;
            } else
            {
                System.out.println("erreur");
                SearchGame.logger.error("erreur");
            }
            // TODO: 11/12/2018 mettre dans un try ?
        }
        return fail;
    }
}
// TODO: 07/12/2018 doc
// TODO: 07/12/2018 log
// TODO: 08/12/2018  log warning