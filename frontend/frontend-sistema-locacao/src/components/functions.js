module.exports = {
    changeStateObj(e, obj) {
        const { name, value } = e.target;
        obj[name] = value;
        return obj;
    },
}