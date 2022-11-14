package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();
        lottoService = new LottoService();
    }

    public void play() {
        Long purchaserId = -1L;
        int money = 0;

        try {
            money = inputView.inputMoney();
            purchaserId = lottoService.generatePurchaser(money);
            lottoService.buyLotto(purchaserId);
            printLottos(lottoService.findPurchaserLottos(purchaserId));
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return;
        }
    }

    private void printLottos(List<List<Integer>> purchaserLottos) {
        outputView.printLottoQuantity(purchaserLottos.size());
        for(List<Integer> purchaserLotto : purchaserLottos){
            outputView.printLotto(purchaserLotto);
        }
    }

}
