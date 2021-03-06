package interview.veripark.com.ui.fragment.stock;

import java.util.List;

import interview.veripark.com.data.network.model.StockResponse;
import interview.veripark.com.ui.base.BaseMvpView;

/**
 * Created by mertKaradeniz on 7.11.2021
 * <p>
 * This is an interview project.
 */

public interface StockAndIndexMvpView extends BaseMvpView {

    void updateStocks(List<StockResponse.Stock> response);
}