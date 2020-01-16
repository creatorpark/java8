package creatorpark.reactive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PublishAndSubscribeOn {

	public static void main(String[] args) {
		
		
		Publisher<Integer> pub = sub -> {
			
			sub.onSubscribe(new Subscription() {
			
				@Override
				public void request(long n) {
					sub.onNext(1);
					sub.onNext(2);
					sub.onNext(3);
					sub.onNext(4);
					sub.onComplete();
				}
				
				@Override
				public void cancel() {
					
				}
			});
		};
		
		Publisher<Integer> subOnPub = sub -> {
			ExecutorService es = Executors.newSingleThreadExecutor();
			es.execute(() -> pub.subscribe(sub));
		};
		
		Publisher<Integer> pubOnPub = sub -> {

			subOnPub.subscribe(new Subscriber<Integer>() {
				ExecutorService es = Executors.newSingleThreadExecutor();

				@Override
				public void onSubscribe(Subscription subscription) {
					sub.onSubscribe(subscription);
				}

				@Override
				public void onNext(Integer item) {
					es.execute(() -> sub.onNext(item) );
				}

				@Override
				public void onError(Throwable throwable) {
					es.execute(() ->sub.onError(throwable) );
				}

				@Override
				public void onComplete() {
					es.execute(() -> sub.onComplete() );
				}
			});
		};
		
		pubOnPub.subscribe(new Subscriber<Integer>() {

			@Override
			public void onSubscribe(Subscription subscription) {
				log.debug("onSubscribe");
				subscription.request(Long.MAX_VALUE);
			}

			@Override
			public void onNext(Integer item) {
				log.debug("onNext : {}", item);
			}

			@Override
			public void onError(Throwable throwable) {
				log.debug("onError : {} ", throwable );
			}

			@Override
			public void onComplete() {
				log.debug("onComplete");
//				if ( 1 == 1 ) throw new RuntimeException();
				
			}
		});
		log.debug("EXIT");
	}
}
