package com.example.parking.constant;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * This class will be used to store the constructor values in the DB instead of default ordinal values.
 */
public abstract class ImmutableType<T> implements UserType {
    private final Class<T> clazz;
    protected ImmutableType(Class<T> clazz) {
        this.clazz = clazz;
    }
    @Override
    public Object nullSafeGet(
            ResultSet rs,
            String[] names,
            SharedSessionContractImplementor session,
            Object owner)
            throws SQLException {
        return get(rs, names, session, owner);
    }
    @Override
    public void nullSafeSet(
            PreparedStatement st,
            Object value,
            int index,
            SharedSessionContractImplementor session)
            throws SQLException {
        set(st, clazz.cast(value), index, session);
    }
    protected abstract T get(
            ResultSet rs,
            String[] names,
            SharedSessionContractImplementor session,
            Object owner) throws SQLException;
    protected abstract void set(
            PreparedStatement st,
            T value,
            int index,
            SharedSessionContractImplementor session)
            throws SQLException;
    @Override
    public Class<T> returnedClass() {
        return clazz;
    }
    @Override
    public boolean equals(Object x, Object y) {
        return Objects.equals(x, y);
    }
    @Override
    public int hashCode(Object x) {
        return x.hashCode();
    }
    @Override
    public Object deepCopy(Object value) {
        return value;
    }
    @Override
    public boolean isMutable() {
        return false;
    }
    @Override
    public Serializable disassemble(Object o) {
        return (Serializable) o;
    }
    @Override
    public Object assemble(
            Serializable cached,
            Object owner) {
        return cached;
    }

    @Override
    public Object replace(
            Object o,
            Object target,
            Object owner) {
        return o;
    }
}
