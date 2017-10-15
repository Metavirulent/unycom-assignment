let calculateFinalPrice = (price) => {
    let rate = 0;
    if (price < 1000) {
        rate = 0.01;
    } else if (price >= 1000 && price < 5000) {
        rate = 0.02;
    } else if (price >= 5000 && price < 20000) {
        rate = 0.05;
    } else if (price >= 20000) {
        rate = 0.1;
    } else {
        rate = 0;
    }
    return Math.ceil(price * (1-rate));
};

export {calculateFinalPrice};