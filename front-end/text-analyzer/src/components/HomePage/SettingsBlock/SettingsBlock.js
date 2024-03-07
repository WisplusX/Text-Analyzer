import React, { useState } from "react";
import { Flex, Icon, Heading, Box } from "@chakra-ui/react";
import { IoSettingsSharp } from "react-icons/io5";
import WordsOptions from "./WordsOptions";
import CharactersOptions from "./CharactersOptions";
import OtherOptions from "./OtherOptions";

const SettingsBlock = ({
  onWordsOptionsChange,
  onOtherOptionsChange,
  onCharactersOptionsChange,
}) => {
  return (
    <Flex direction="column">
      <Flex align="center" my="2">
        <Icon as={IoSettingsSharp} boxSize="20px" mr="2" />
        <Heading size="md">Налаштування аналізу</Heading>
      </Flex>

      <Heading size="sm" color="gray.500" mb="4" fontWeight="400">
        Кількість увімкнених опцій може впливати на швидкість роботи аналізатора
      </Heading>

      <WordsOptions onChange={onWordsOptionsChange} />
      <CharactersOptions onChange={onCharactersOptionsChange} />
      <OtherOptions onChange={onOtherOptionsChange} />
      <Box mb="10" />
    </Flex>
  );
};

export default SettingsBlock;
