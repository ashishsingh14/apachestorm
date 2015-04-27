package com.learningstorm.storm_example;
import java.util.*;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.generated.AlreadyAliveException;
import backtype.storm.generated.InvalidTopologyException;
import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.testing.TestWordSpout;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import backtype.storm.utils.Utils;

public class LearningStormSpout extends BaseRichSpout{ 
	private static final long serialVersionUID = 1L; 
	private SpoutOutputCollector spoutOutputCollector; 
	private static final Map<Integer, String> map = new HashMap<Integer, String>(); 
	static { 
		map.put(0, "google"); 
		map.put(1, "facebook"); 
		map.put(2, "twitter"); 
		map.put(3, "youtube"); 
		map.put(4, "linkedin"); } 
	public void open(Map conf, TopologyContext context, SpoutOutputCollector spoutOutputCollector) { 
		// Open the spout 
		this.spoutOutputCollector = spoutOutputCollector; 
		} 
	public void nextTuple() { // Storm cluster repeatedly calls this method to emit a continuous // stream of tuples. 
		final Random rand = new Random(); // generate the random number from 0 to 4. 
		int randomNumber = rand.nextInt(5); 
		spoutOutputCollector.emit(new Values(map.get(randomNumber))); } 
	
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("site"));
	}
}
