import httpcommon from "./http_common";
class UserService {
    createUser(user) {
        return httpcommon.post("/users/createUser", user);
    }
    getUsers() {
        return httpcommon.get();
    }
    getUserByName(name) {
        return httpcommon.get(name);
    }
    deleterByName(name) {
        return httpcommon.delete(name);
    }
    updateByName(name) {
        return httpcommon.delete(name);
    }
}

export default new UserService();