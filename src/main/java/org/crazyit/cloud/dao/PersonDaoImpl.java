package org.crazyit.cloud.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.crazyit.cloud.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;

public class PersonDaoImpl implements PersonDaoCustom {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Person> myQuery() {
		return mongoTemplate.execute(Person.class, new CollectionCallback<List<Person>>() {

			public List<Person> doInCollection(DBCollection collection)
					throws MongoException, DataAccessException {
				
				DBCursor cursor = collection.find();
				List<Person> result = new ArrayList<Person>();
				while(cursor.hasNext()) {
					DBObject source = cursor.next();
					Person p = new Person();
					ObjectId objectId = (ObjectId)source.get("_id");
					p.setId(objectId.toHexString());
					p.setAge((Integer) source.get("age"));
					p.setName((String) source.get("name"));
					p.setCompany((String) source.get("company"));
					result.add(p);
				}
				
				return result;
			}
			
		});
	}

}
