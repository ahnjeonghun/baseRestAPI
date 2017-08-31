package com.example.demo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import java.time.LocalDateTime;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Rule
	public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	private RestDocumentationResultHandler document;
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
				.defaultRequest(get("/"))
				.apply(
						documentationConfiguration(this.restDocumentation)
				).build();
	}


	@Test
	public void contextLoads() {
	}
	@Test
	public void testGetAll() throws Exception {
		this.mockMvc.perform(get("/members"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("[0].memberIdx").value(1))
				.andExpect(jsonPath("[0].memberName").value("안정훈"))
				.andExpect(jsonPath("[0].addr").value("서울"))
				.andExpect(jsonPath("[0].ph1").value("01035896410"))
				.andExpect(jsonPath("[1].memberIdx").value(2))
				.andExpect(jsonPath("[1].memberName").value("배창현"))
				.andExpect(jsonPath("[1].addr").value("서울"))
				.andExpect(jsonPath("[1].ph1").value("01035896410"))
				.andExpect(jsonPath("[2].memberIdx").value(3))
				.andExpect(jsonPath("[2].memberName").value("김보훈"))
				.andExpect(jsonPath("[2].addr").value("서울"))
				.andExpect(jsonPath("[2].ph1").value("01035896410"))

				.andDo(document("get-all",
						responseFields(
								fieldWithPath("[].memberIdx").type(JsonFieldType.NUMBER).description("회원 번호"),
								fieldWithPath("[].memberName").type(JsonFieldType.STRING).description("이름"),
								fieldWithPath("[].addr").type(JsonFieldType.STRING).description("주소"),
								fieldWithPath("[].ph1").type(JsonFieldType.STRING).description("Phone")
						)
				));
	}

	@Test
	public void testGetOne() throws Exception {
		this.mockMvc.perform(get("/member/{memberIdx}", 1))
				.andExpect(status().isOk())
				.andExpect(jsonPath("memberIdx").value(1))
				.andExpect(jsonPath("memberName").value("안정훈"))
				.andExpect(jsonPath("addr").value("서울"))
				.andExpect(jsonPath("ph1").value("01035896410"))

				.andDo(document("get-one",
						pathParameters(
								parameterWithName("memberIdx").description("회원번호")
						),
						responseFields(
								fieldWithPath("memberIdx").type(JsonFieldType.NUMBER).description("회원 번호"),
								fieldWithPath("memberName").type(JsonFieldType.STRING).description("이름"),
								fieldWithPath("addr").type(JsonFieldType.STRING).description("주소"),
								fieldWithPath("ph1").type(JsonFieldType.STRING).description("Phone")
						)
				));
	}
	@Test
	public void testCreate() throws Exception {
		this.mockMvc.perform(post("/members")
				.param("memberName", "안소희")
				.param("addr", "수원")
				.param("ph1", "01035896410"))
				.andExpect(status().isCreated())
				.andDo(document("create",
						responseFields(
								fieldWithPath("memberIdx").type(JsonFieldType.NUMBER).description("회원 번호"),
								fieldWithPath("memberName").type(JsonFieldType.STRING).description("이름"),
								fieldWithPath("addr").type(JsonFieldType.STRING).description("주소"),
								fieldWithPath("ph1").type(JsonFieldType.STRING).description("Phone")
						)
				));
	}
}
