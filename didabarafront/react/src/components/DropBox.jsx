import React from "react";
import { useQuery } from "react-query";
import { useRecoilState } from "recoil";
import styled from "styled-components";
import { getjoinedList } from "../config/APIs";
import { myJoinState } from "../config/Atom";

import Profile from "./Profile";

const Area = styled.div`
  background-color: #dcdcdc;
  padding: 2px;
  height: 100%;
`;

function DropBox() {
  //시작
  const [joinState, setMyJoinState] = useRecoilState(myJoinState);
  const { isLoading } = useQuery("JoinedData", getjoinedList, {
    refetchOnWindowFocus: false,
    retry: false,
    onSuccess: (data) => {
      console.log("Result of getting my Join List :", data);
      setMyJoinState(data.data);
    },
  });

  return isLoading ? (
    "loading..."
  ) : (
    <Area>
      {joinState?.map((list, idx) => (
        <Profile
          key={list.id}
          img={list.categoryProfileImageUrl}
          username={list.nickname}
          title={list.title}
          text={list.content}
          idx={idx}
        />
      ))}
    </Area>
  );
}

export default DropBox;
