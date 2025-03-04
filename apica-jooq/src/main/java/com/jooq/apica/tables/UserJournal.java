/*
 * This file is generated by jOOQ.
 */
package com.jooq.apica.tables;


import com.jooq.apica.Keys;
import com.jooq.apica.UserDb;
import com.jooq.apica.tables.records.UserJournalRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserJournal extends TableImpl<UserJournalRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>user_db.user_journal</code>
     */
    public static final UserJournal USER_JOURNAL = new UserJournal();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserJournalRecord> getRecordType() {
        return UserJournalRecord.class;
    }

    /**
     * The column <code>user_db.user_journal.id</code>.
     */
    public final TableField<UserJournalRecord, UInteger> ID = createField(DSL.name("id"), SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>user_db.user_journal.userId</code>.
     */
    public final TableField<UserJournalRecord, UInteger> USERID = createField(DSL.name("userId"), SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>user_db.user_journal.journal</code>.
     */
    public final TableField<UserJournalRecord, String> JOURNAL = createField(DSL.name("journal"), SQLDataType.VARCHAR(512).nullable(false), this, "");

    /**
     * The column <code>user_db.user_journal.created_date</code>.
     */
    public final TableField<UserJournalRecord, LocalDateTime> CREATED_DATE = createField(DSL.name("created_date"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "");

    private UserJournal(Name alias, Table<UserJournalRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserJournal(Name alias, Table<UserJournalRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>user_db.user_journal</code> table reference
     */
    public UserJournal(String alias) {
        this(DSL.name(alias), USER_JOURNAL);
    }

    /**
     * Create an aliased <code>user_db.user_journal</code> table reference
     */
    public UserJournal(Name alias) {
        this(alias, USER_JOURNAL);
    }

    /**
     * Create a <code>user_db.user_journal</code> table reference
     */
    public UserJournal() {
        this(DSL.name("user_journal"), null);
    }

    public <O extends Record> UserJournal(Table<O> child, ForeignKey<O, UserJournalRecord> key) {
        super(child, key, USER_JOURNAL);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : UserDb.USER_DB;
    }

    @Override
    public Identity<UserJournalRecord, UInteger> getIdentity() {
        return (Identity<UserJournalRecord, UInteger>) super.getIdentity();
    }

    @Override
    public UniqueKey<UserJournalRecord> getPrimaryKey() {
        return Keys.KEY_USER_JOURNAL_PRIMARY;
    }

    @Override
    public List<ForeignKey<UserJournalRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FK_USERID);
    }

    private transient User _user;

    /**
     * Get the implicit join path to the <code>user_db.user</code> table.
     */
    public User user() {
        if (_user == null)
            _user = new User(this, Keys.FK_USERID);

        return _user;
    }

    @Override
    public UserJournal as(String alias) {
        return new UserJournal(DSL.name(alias), this);
    }

    @Override
    public UserJournal as(Name alias) {
        return new UserJournal(alias, this);
    }

    @Override
    public UserJournal as(Table<?> alias) {
        return new UserJournal(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserJournal rename(String name) {
        return new UserJournal(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserJournal rename(Name name) {
        return new UserJournal(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserJournal rename(Table<?> name) {
        return new UserJournal(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<UInteger, UInteger, String, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super UInteger, ? super UInteger, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super UInteger, ? super UInteger, ? super String, ? super LocalDateTime, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
