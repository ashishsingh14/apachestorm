package com.learningstorm.storm_example;
import java.util.*;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.testing.TestWordSpout;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

public class LearningStormBolt extends BaseBasicBolt{ 
	private static final long serialVersionUID = 1L; 
	public void execute(Tuple input, BasicOutputCollector collector) { 
		// fetched the field "site" from input tuple. 
		String test = input.getStringByField("site"); // print the value of field "site" on console. 
		System.out.println("Name of input site is : " + test); } 
	public void declareOutputFields(OutputFieldsDeclarer declarer) { }
	
}
