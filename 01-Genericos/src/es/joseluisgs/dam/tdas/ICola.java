package es.joseluisgs.dam.tdas;

import java.util.Collection;

/**
 * Contrato que toda Cola debe cumplir
 */
public interface ICola<T> extends Collection<E> {
    /**
     * Encola un item
     *
     * @param item item a encolar
     */
    void encolar(E item);

    /**
     * Desencola un Item
     *
     * @return item
     */
    E desencolar();
}
