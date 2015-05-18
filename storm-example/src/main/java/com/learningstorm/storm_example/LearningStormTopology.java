package com.learningstorm.storm_example;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.testing.TestWordSpout;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

public class LearningStormTopology { 
	public static void main(String[] args) throws  AlreadyAliveException, InvalidTopologyException { 
		// create an instance of TopologyBuilder class 
		TopologyBuilder builder = new TopologyBuilder(); // set the spout class 
		builder.setSpout("LearningStormSpout", new LearningStormSpout(), 1); // set the bolt class 
		builder.setBolt("LearningStormBolt", new LearningStormBolt(), 1).shuffleGrouping ("LearningStormSpout");
		
		Config conf = new Config(); 
		conf.setDebug(true);
		LocalCluster cluster = new LocalCluster();
		
		cluster.submitTopology("LearningStormToplogy", conf, builder.createTopology()); 
		try { 
				Thread.sleep(10000); 
			} catch (Exception exception) { 
				System.out.println("Thread interrupted exception : " + exception); 
				}
		cluster.killTopology("LearningStormToplogy");
		cluster.shutdown();
	}
}
