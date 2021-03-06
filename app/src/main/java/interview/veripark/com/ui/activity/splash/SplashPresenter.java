package interview.veripark.com.ui.activity.splash;



import javax.inject.Inject;

import interview.veripark.com.data.DataManager;
import interview.veripark.com.data.network.model.HandShakeRequest;
import interview.veripark.com.ui.base.BasePresenter;
import interview.veripark.com.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by mertKaradeniz on 7.11.2021
 * <p>
 * This is an interview project.
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {

    @Inject
    public SplashPresenter(DataManager mDataManager, SchedulerProvider mSchedulerProvider, CompositeDisposable mCompositeDisposable) {
        super(mDataManager, mSchedulerProvider, mCompositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Override
    public void onHandShakeStart(HandShakeRequest shakeRequest) {

        getCompositeDisposable().add(getDataManager()
                .doHandShakeStartApiCall(shakeRequest.toJSONString())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response -> {

                    System.out.println(response.toString());

                    getDataManager().updateApiHeader(
                            response.getAesKey(),
                            response.getAesIV(),
                            response.getAuthorization()
                    );

                    if (!isViewAttached()) {
                        return;
                    }
                    getMvpView().openMainActivity();
                }, throwable -> {
                    if (!isViewAttached()) {
                        return;
                    }
                    getMvpView().hideLoading();
                }));


    }
}
