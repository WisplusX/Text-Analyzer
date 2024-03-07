import React from "react";
import { Box, Text } from "@chakra-ui/react";

const SingleWordCard = ({ word, counter, probability }) => {
  return (
    <Box
      borderWidth="1px"
      borderRadius="md"
      p="4"
      mr="4"
      mb="2"
      textAlign="center"
    >
      <Text fontSize="md" fontWeight="400">
        {word}
      </Text>
      <Text fontSize="3xl" fontWeight="bold">
        {counter}
      </Text>
      <Text fontSize="md" fontWeight="400">
        {(probability * 100).toFixed(2)}%
      </Text>
    </Box>
  );
};

export default SingleWordCard;
