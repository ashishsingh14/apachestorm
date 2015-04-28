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


public class LearningStormSingleNodeTopology {
	public static void main(String[] args)
	{
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("LearningStormSpout", new LearningStormSpout(), 4);
		builder.setBolt("LearningStormBolt", new LearningStormBolt(), 2) .shuffleGrouping("LearningStormSpout");
		Config conf = new Config();
		conf.setNumWorkers(3);
		try {
			StormSubmitter.submitTopology(args[0], conf, builder.createTopology());
		}catch(AlreadyAliveException alreadyAliveException){
			System.out.println(alreadyAliveException);
		}catch(InvalidTopologyException invalidTopologyException){
			System.out.println(invalidTopologyException);
		}
	}

}
