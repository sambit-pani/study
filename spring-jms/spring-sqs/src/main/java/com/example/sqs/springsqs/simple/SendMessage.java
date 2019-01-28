package com.example.sqs.springsqs.simple;

import java.util.List;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class SendMessage {

	public static void main(String[] args) throws InterruptedException {
		BasicAWSCredentials awsCreds = new BasicAWSCredentials("key",
				"id");
		AmazonSQS sqs = AmazonSQSClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCreds))
				.withRegion("us-east-2").build();
		ListQueuesResult lq_result = sqs.listQueues();
		System.out.println("Your SQS Queue URLs:");
		for (String url : lq_result.getQueueUrls()) {
			System.out.println(url);
		}
		String queue_url = sqs.getQueueUrl("message").getQueueUrl();
		SendMessageRequest send_msg_request = new SendMessageRequest()
		        .withQueueUrl(queue_url)
		        .withMessageBody("hello world3")
		        .withDelaySeconds(1);
		Thread.sleep(5000);
		//sqs.sendMessage(send_msg_request);
		List<Message> messages = sqs.receiveMessage(queue_url).getMessages();
		for(Message msg:messages) {
			System.out.println("sambit "+msg.getBody());
			sqs.deleteMessage(queue_url, msg.getReceiptHandle());
		}
	}
}
