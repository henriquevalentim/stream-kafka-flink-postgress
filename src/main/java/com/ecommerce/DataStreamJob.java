package com.ecommerce;

import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.connector.kafka.source.KafkaSource;
import org.apache.flink.connector.kafka.source.enumerator.initializer.OffsetsInitializer;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import com.Deserializer.JSONValueDeserializationSchema;
import com.Dto.Transaction;


public class DataStreamJob {

	public static void main(String[] args) throws Exception {

		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

		String topic = "financial_transactions";
		KafkaSource<Transaction> source = KafkaSource.<Transaction>builder()
				.setBootstrapServers("localhost:9092")
					.setTopics(topic)
					.setGroupId("flink-group")
					.setStartingOffsets(OffsetsInitializer.earliest())
					.setValueOnlyDeserializer(new JSONValueDeserializationSchema())
					.build();

					DataStream<Transaction> transactionStream = env.fromSource(source, WatermarkStrategy.noWatermarks(), "Kafka source");
					transactionStream.print();

		env.execute("Flink Java API Skeleton");
	}
}
