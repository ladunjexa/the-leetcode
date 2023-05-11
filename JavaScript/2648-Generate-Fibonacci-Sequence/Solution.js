/**
 * @return {Generator<number>}
 */
var fibGenerator = function*() {
    let e1 = 0, e2 = 1, e;
    while(true) {
        e = e1 + e2;
        yield e1;
        e1 = e2;
        e2 = e;
    }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */