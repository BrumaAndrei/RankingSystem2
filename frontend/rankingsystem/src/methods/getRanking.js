import API from "../utility/api";

const getRanking = async (criteria) => {
  try {
    const response = await API.get(`/user/ranking/${criteria}`);
    console.log("ranking ", response.data);
    return response.data;
  } catch (e) {
    console.log(e);
  }
};

export default getRanking;
