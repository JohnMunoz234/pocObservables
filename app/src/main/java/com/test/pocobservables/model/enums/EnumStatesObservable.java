package com.test.pocobservables.model.enums;

public enum EnumStatesObservable {

    INITIAL_STATUS {
        @Override
        public String toString() {
            return "INITIAL_STATUS";
        }
    },
    INTERMEDIATE_STATUS {
        @Override
        public String toString() {
            return "INTERMEDIATE_STATUS ";
        }
    },
    FINAL_STATUS {
        @Override
        public String toString() {
            return "FINAL_STATUS";
        }
    };

    public abstract String toString();
}
