package ru.cloud.storage.backendjavacloudstorage.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @param <Q> - requestDTO
 * @param <A> - responseDTO
 */
public interface BaseService<Q,A> {

    A getReferenceById(@PathVariable("id") String id);

    A create(@RequestBody Q request);

    A update(@RequestBody Q request);

    Boolean delete(@PathVariable("id") String id);

}