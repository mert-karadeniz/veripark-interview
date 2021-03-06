package interview.veripark.com.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import interview.veripark.com.MainApplication;
import interview.veripark.com.data.DataManager;
import interview.veripark.com.di.ApplicationContext;
import interview.veripark.com.di.module.ApplicationModule;
import okhttp3.Interceptor;

/**
 * Created by mertKaradeniz on 6.11.2021
 * <p>
 * This is an interview project.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainApplication app);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();


}
