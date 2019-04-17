import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;

/**
 * kafka生产者
 * lwf 2019-04-17
 */
public class KafkaProducerExample {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.92.129:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer",  StringSerializer.class.getName());
        props.put("value.serializer",  StringSerializer.class.getName());
        Producer producer = new KafkaProducer(props);
        int i = 0;
        while (true) {
            producer.send(new ProducerRecord("topic1", "key"+i,"message: " + i++));
            try {
               Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyProducer.main");
        }
    }
}
