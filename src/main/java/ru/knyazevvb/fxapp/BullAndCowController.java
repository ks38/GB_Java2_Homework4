package ru.knyazevvb.fxapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class BullAndCowController {
    private Game game;
    private int step;

    @FXML
    private TextArea tipArea;
    @FXML
    private TextField answerField;

    public BullAndCowController() {
        game = new Game();
        step = 1;
    }

    // добавил блоки try-catch, чтобы не программа не крашилась
    public void onClickCheckButton(ActionEvent actionEvent) {
        try {
            final String answer = answerField.getText();
            if (answer != null && !answer.isEmpty()) {
                final Game.BullCowCount bullCowCount = game.calc(answer);
                final String tip = String.format("%d. Введено число %s: быков %d, коров %d", step, answer,
                        bullCowCount.getBulls(), bullCowCount.getCows());
                step++;
                tipArea.appendText(tip + "\n");
                answerField.clear();
                if (bullCowCount.getBulls() == 4) {
                    if (isPlayerWantsToPlayAgain()) {
                        runNewGame();
                    } else {
                        System.exit(0);
                    }
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Произошла ошибка");
        }
    }

    private void runNewGame() {
        step = 1;
        tipArea.clear();
        this.game = new Game();
    }


    private boolean isPlayerWantsToPlayAgain() {
        final Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Поздравляю, вы выиграли!\n" +
                        "Загаданное число: " + game.getGuessNumber() + "\n" +
                        "\n" +
                        "Желаете сыграть еще?",
                new ButtonType("Да", ButtonBar.ButtonData.YES),
                new ButtonType("Нет", ButtonBar.ButtonData.NO));
        final ButtonType buttonType = alert.showAndWait().get();
        return buttonType.getButtonData() == ButtonBar.ButtonData.YES;
    }

    public void onGameSelect(ActionEvent actionEvent) {
        runNewGame();
    }

    public void onExitSelect(ActionEvent actionEvent) {
        System.exit(0);
    }

}