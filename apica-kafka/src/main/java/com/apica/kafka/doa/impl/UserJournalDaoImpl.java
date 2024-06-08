package com.apica.kafka.doa.impl;

import static com.jooq.apica.tables.UserJournal.USER_JOURNAL;

import java.util.ArrayList;
import java.util.List;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apica.kafka.doa.UserJournalDao;
import com.apica.kafka.model.UserJournal;
import com.jooq.apica.tables.records.UserJournalRecord;

@Repository
public class UserJournalDaoImpl implements UserJournalDao {

	@Autowired
	DSLContext dslContext;

	@Override
	public void publishJournal(UserJournal journal) throws Exception {
		try {
			UserJournalRecord userRecord = dslContext.newRecord(USER_JOURNAL, journal);
			userRecord.insert();
		}catch (Exception e) {
			throw new Exception("Dao error while storing user journal");
		}
	}
	
	@Override
	public List<UserJournal> getAll(Integer userId) throws Exception {
		List<UserJournal> journalList = null;
		try {
			List<Condition> conditions = new ArrayList<>();
			conditions.add(DSL.trueCondition());
			if (userId != null) {
				conditions.add(USER_JOURNAL.USERID.eq(UInteger.valueOf(userId)));
			}
			journalList = dslContext.selectFrom(USER_JOURNAL).where(conditions).fetchInto(UserJournal.class);
		} catch (Exception e) {
			throw new Exception("Dao error while fetching user journals");
		}
		return journalList;
	}
	
}
