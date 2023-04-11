import API from "../utility/api";

const getUserStartedQuestsById = async (userId) => {
  try {
    const response = await API.get(`/userTriesQuest/${userId}`);
    console.log("quests ", response.data);
    return response.data;
  } catch (e) {
    console.log(e);
  }
};

export default getUserStartedQuestsById;
