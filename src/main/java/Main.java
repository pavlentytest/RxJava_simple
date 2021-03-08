import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;

public class Main {

    public static void main(String[] args) {

        Observable<String> myObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                int i= 0;
                while(i<5) {
                    emitter.onNext("Hello World "+ i);
                    i++;
                }
                emitter.onComplete();
            }
        });




        Observer<String> myObserver = new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("myObserber subcribed on myObservable");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("myObserver onNext(): "+ s);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
            @Override
            public void onComplete() {
                System.out.println("Observer completed!");
            }
        };
        myObservable.subscribe(myObserver);







    }
}
