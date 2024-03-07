import React from "react";
import { Flex, Box, Heading, Icon, Divider } from "@chakra-ui/react";
import { IoAnalytics } from "react-icons/io5";

const Header = () => {
  return (
    <Box>
      <Flex alignItems="center" w="100%" pt="4" pb="3">
        <Box>
          <Icon as={IoAnalytics} boxSize="30px" />
        </Box>
        <Heading size="md" fontWeight="600" ml="2" mb="1">
          Text Analyzer
        </Heading>
      </Flex>
      <Divider borderColor="rgba(0, 0, 0, 0.2)" />
    </Box>
  );
};

export default Header;
