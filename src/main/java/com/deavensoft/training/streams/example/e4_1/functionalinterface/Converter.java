package com.deavensoft.training.streams.example.e4_1.functionalinterface;

@FunctionalInterface
public interface Converter<V, T> {
	T convert(V value);
}
