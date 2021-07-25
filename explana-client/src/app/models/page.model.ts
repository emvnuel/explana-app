export interface Page<T> {
  content:          T[];
  pageable:         Pageable;
  last:             boolean;
  totalPages:       number;
  totalElements:    number;
  first:            boolean;
  numberOfElements: number;
  size:             number;
  number:           number;
  sort:             Sort;
  empty:            boolean;
}

export interface Pageable {
  sort:       Sort;
  pageSize:   number;
  pageNumber: number;
  offset:     number;
  paged:      boolean;
  unpaged:    boolean;
}

export interface Sort {
  sorted:   boolean;
  unsorted: boolean;
  empty:    boolean;
}
