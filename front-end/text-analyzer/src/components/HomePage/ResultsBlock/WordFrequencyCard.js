import React from "react";
import { Flex, Text, Heading, Box } from "@chakra-ui/react";
import SingleWordCard from "./SingleWordCard";

const WordsFrequenciesCard = ({ data, label }) => {
  if (!data) {
    return null;
  }

  return (
    <Flex
      direction="column"
      w="100%"
      bgColor="white"
      p="6"
      borderRadius="6"
      mb="4"
    >
      <Heading size="md" mb="4">
        {label}
      </Heading>
      <Flex overflowX="auto">
        {data.map((item, index) => (
          <SingleWordCard
            key={index}
            word={item.word}
            counter={item.counter}
            probability={item.probability}
          />
        ))}
      </Flex>
    </Flex>
  );
};

export default WordsFrequenciesCard;
