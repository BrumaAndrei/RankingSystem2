import API from "../utility/api";

const getUserQuestsById = async (userId) => {
  try {
    const response = await API.get(`/quest/${userId}`);
    console.log("quests ", response.data);
    return response.data;
  } catch (e) {
    console.log(e);
  }
};

export default getUserQuestsById;
