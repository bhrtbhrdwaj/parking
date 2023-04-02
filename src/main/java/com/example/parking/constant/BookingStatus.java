package com.example.parking.constant;

import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookingStatus extends ImmutableType<BookingStatus.Status> {

    public enum Status {
        PARKED(0),
        UN_PARKED(1);
        private static final Map<Integer, Status> map;
        static {
            map = Arrays.stream(Status.values()).collect(Collectors.toMap(Status::getValue, Function.identity()));
        }
        private final int value;
        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Status getDefault() {
            return null;
        }

        public static Status getType(int value) {
            return map.getOrDefault(value, getDefault());
        }

    }

    public BookingStatus() {
        super(Status.class);
    }

    @Override
    protected Status get(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws SQLException {
        int value = rs.getInt(names[0]);
        return Status.getType(value);
    }

    @Override
    protected void set(PreparedStatement st, Status status, int index, SharedSessionContractImplementor session) throws SQLException {
        if (status == null) {
            st.setNull(index, Types.INTEGER);
        } else {
            st.setInt(index, status.value);
        }
    }

    /**
     * Return the SQL type codes for the columns mapped by this type. The
     * codes are defined on <tt>java.sql.Types</tt>.
     *
     * @return int[] the type codes
     * @see Types
     */
    @Override
    public int[] sqlTypes() {
        return new int[]{Types.INTEGER};
    }
}