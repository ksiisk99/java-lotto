package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        int money = 0;

        try {
            money = inputView.inputMoney();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return;
        }
    }


}
