package com.cheguo.reactortest;

import java.util.Optional;

import reactor.core.publisher.Mono;

public class MonoTester {

    public static void main(String[] args) {
	
	Mono.just("Hello1").subscribe(System.out::println);

	Mono.fromCallable(() -> "9999").subscribe(System.out::println);

	Mono.fromSupplier(() -> "Hello2").subscribe(System.out::println);
	Mono.justOrEmpty(Optional.of("Hello3")).subscribe(System.out::println);
	Mono.create(sink -> sink.success("Hello4")).subscribe(System.out::println);

	Mono.defer(() -> {
	    return Mono.error(new RuntimeException());
	}).subscribe();

    }

}
