import React from "react";
import { useRecoilValue } from "recoil";
import styled from "styled-components";
import { didabaraState } from "../config/Atom";
import MyList from "./MyList";

const StyledGrid = styled.div`
  background-color: #dcdcdc;
  overflow-y: scroll;
  overflow-x: hidden;
  height: 100%;
  ::-webkit-scrollbar {
    width: 1px;
  }
  ::-webkit-scrollbar-button {
    width: 0;
    height: 0;
  }
  ::-webkit-scrollbar-thumb {
    border-radius: 3px;
    background-color: gray;
  }
`;

function ShowMyList() {
  const didabara = useRecoilValue(didabaraState);

  return (
    <StyledGrid>
      {didabara?.create
        ? didabara.create.map((list) => (
            <MyList
              key={list.id}
              title={list.title}
              content={list.content}
              imgSrc={list.profileImageUrl}
              id={list.id}
              code={list.inviteCode}
              host={list.host}
            />
          ))
        : null}
    </StyledGrid>
  );
}

export default ShowMyList;
