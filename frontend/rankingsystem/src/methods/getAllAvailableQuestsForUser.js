import API from "../utility/api";

const getAllAvailableQuestsForUser = async (userId) => {
  try {
    const response = await API.get(`/userTriesQuest/available/${userId}`);
    console.log("quests ", response.data);
    return response.data;
  } catch (e) {
    console.log(e);
  }
};

export default getAllAvailableQuestsForUser;
