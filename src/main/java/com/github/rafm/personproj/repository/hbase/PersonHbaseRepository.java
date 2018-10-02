package com.github.rafm.personproj.repository.hbase;

import java.util.List;

import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.stereotype.Repository;

import com.github.rafm.personproj.model.Person;

@Repository
public class PersonHbaseRepository {

	@Autowired private HbaseTemplate hbaseTemplate;
	
	private static byte[] CF_DATA = Bytes.toBytes("data");
	
	private static byte[] CQ_NAME = Bytes.toBytes("name");
	private static byte[] CQ_COUNTRY = Bytes.toBytes("country");
	
	public List<Person> findAll() {
		return hbaseTemplate.find("person", "data", (result, rowNum) -> {
			return new Person(Bytes.toString(result.getValue(CF_DATA, CQ_NAME)),
								Bytes.toString(result.getValue(CF_DATA, CQ_COUNTRY)));
		});
	}
}
