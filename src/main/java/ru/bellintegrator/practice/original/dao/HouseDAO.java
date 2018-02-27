package ru.bellintegrator.practice.original.dao;

import ru.bellintegrator.practice.original.model.House;

import java.util.List;

/**
 * DAO для работы с House
 */
public interface HouseDAO {
    /**
     * Получить все объекты House
     *
     * @return
     */
    List<House> all();

    /**
     * Получить House по идентификатору
     *
     * @param id
     * @return
     */
    House loadById(Long id);

    /**
     * Сохранить House
     *
     * @param house
     */
    void save(House house);
}
