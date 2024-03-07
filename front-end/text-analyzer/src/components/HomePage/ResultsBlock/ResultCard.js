import React from "react";
import { Flex, Text } from "@chakra-ui/react";

const ResultCard = ({ value, label, additionalText }) => {
  return (
    <Flex
      bg="white"
      borderRadius="md"
      pl="6"
      pr="8"
      py="4"
      direction="column"
      mb="4"
      w="fit-content"
      mr="4"
    >
      <Text fontSize="md" fontWeight="500" color="rgba(0, 0, 0, 0.5)">
        {label}
      </Text>
      <Flex alignItems="baseline">
        <Text fontSize="6xl" my="-2">
          {value}
        </Text>
        {additionalText && (
          <Text fontSize="md" fontWeight={500} ml="2">
            {additionalText}
          </Text>
        )}
      </Flex>
    </Flex>
  );
};

export default ResultCard;
