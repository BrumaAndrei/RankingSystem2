import API from "../utility/api";

const getUser = async (userId) => {
  try {
    const response = await API.get(`/user/${userId}`);
    console.log("user ", response.data);
    return response.data;
  } catch (e) {
    console.log(e);
  }
};

export default getUser;
