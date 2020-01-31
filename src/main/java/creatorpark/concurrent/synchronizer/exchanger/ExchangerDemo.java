package creatorpark.concurrent.synchronizer.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExchangerDemo {
	final static Exchanger<DataBuffer> exchanger = new Exchanger<DataBuffer>();
	final static DataBuffer initialEmptyBuffer = new DataBuffer();
	final static DataBuffer initialFullBuffer = new DataBuffer("I");

	public static void main(String[] args) {
		class FillingLoop implements Runnable {
			int count = 0;

			@Override
			public void run() {
				DataBuffer currentBuffer = initialEmptyBuffer;
				try

				{
					while (true) {
						addToBuffer(currentBuffer);
						if (currentBuffer.isFull()) {
							log.info("filling thread wants to exchange");
							currentBuffer = exchanger.exchange(currentBuffer);
							log.info("filling thread receives exchange");
						}
					}
				} catch (InterruptedException ie) {
					log.info("filling thread interrupted");
				}
			}

			void addToBuffer(DataBuffer buffer) {
				String item = "NI" + count++;
				log.info("Adding: " + item);
				buffer.add(item);
			}
		}
		class EmptyingLoop implements Runnable {
			@Override
			public void run() {
				DataBuffer currentBuffer = initialFullBuffer;
				try {
					while (true) {
						takeFromBuffer(currentBuffer);
						if (currentBuffer.isEmpty()) {
							log.info("emptying thread wants to " + "exchange");
							currentBuffer = exchanger.exchange(currentBuffer);
							log.info("emptying thread receives " + "exchange");
						}
					}
				}

				catch (InterruptedException ie) {
					log.info("emptying thread interrupted");
				}
			}

			void takeFromBuffer(DataBuffer buffer) {
				log.info("taking: " + buffer.remove());
			}
		}
		new Thread(new EmptyingLoop()).start();
		new Thread(new FillingLoop()).start();
	}
}

class DataBuffer {
	private final static int MAXITEMS = 10;
	private final List<String> items = new ArrayList<>();

	DataBuffer() {
	}

	DataBuffer(String prefix) {
		for (int i = 0; i < MAXITEMS; i++) {
			String item = prefix + i;
			System.out.printf("Adding %s%n", item);
			items.add(item);
		}
	}

	synchronized void add(String s) {
		if (!isFull())
			items.add(s);
	}

	synchronized boolean isEmpty() {
		return items.size() == 0;
	}

	synchronized boolean isFull() {
		return items.size() == MAXITEMS;
	}

	synchronized String remove() {
		if (!isEmpty())
			return items.remove(0);
		return null;
	}
}