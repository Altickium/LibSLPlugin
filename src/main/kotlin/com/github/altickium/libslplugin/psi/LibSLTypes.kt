package com.github.altickium.libslplugin.psi

import LibSLLexer
import LibSLParser
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.diagnostic.Logger
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.RuleIElementType
import com.github.altickium.libslplugin.antlr.LabeledRuleIElementType
import com.github.altickium.libslplugin.LibSLLanguage

object LibSLTypes {
    init {
        PSIElementTypeFactory.defineLanguageIElementTypes(
            LibSLLanguage.Companion.INSTANCE, LibSLLexer.tokenNames, LibSLParser.ruleNames
        )
    }

    val FILE = IFileElementType(LibSLLanguage.Companion.INSTANCE)

    private val TOKENS = PSIElementTypeFactory.getTokenIElementTypes(LibSLLanguage.Companion.INSTANCE)
    val SEMICOLON = TOKENS[LibSLLexer.SEMICOLON]!!
    val ASSIGN_OP = TOKENS[LibSLLexer.ASSIGN_OP]!!
    val EQ = TOKENS[LibSLLexer.EQ]!!
    val L_BRACE = TOKENS[LibSLLexer.L_BRACE]!!
    val R_BRACE = TOKENS[LibSLLexer.R_BRACE]!!
    val L_BRACKET = TOKENS[LibSLLexer.L_BRACKET]!!
    val R_BRACKET = TOKENS[LibSLLexer.R_BRACKET]!!
    val L_SQUARE_BRACKET = TOKENS[LibSLLexer.L_SQUARE_BRACKET]!!
    val R_SQUARE_BRACKET = TOKENS[LibSLLexer.R_SQUARE_BRACKET]!!
    val DOT = TOKENS[LibSLLexer.DOT]!!
    val COLON = TOKENS[LibSLLexer.COLON]!!
    val COMMA = TOKENS[LibSLLexer.COMMA]!!
    val MINUS_ARROW = TOKENS[LibSLLexer.MINUS_ARROW]!!
    val L_ARROW = TOKENS[LibSLLexer.L_ARROW]!!
    val R_ARROW = TOKENS[LibSLLexer.R_ARROW]!!
    val ASTERISK = TOKENS[LibSLLexer.ASTERISK]!!
    val SLASH = TOKENS[LibSLLexer.SLASH]!!
    val PERCENT = TOKENS[LibSLLexer.PERCENT]!!
    val PLUS = TOKENS[LibSLLexer.PLUS]!!
    val MINUS = TOKENS[LibSLLexer.MINUS]!!
    val INCREMENT = TOKENS[LibSLLexer.INCREMENT]!!
    val DECREMENT = TOKENS[LibSLLexer.DECREMENT]!!
    val PLUS_EQ = TOKENS[LibSLLexer.PLUS_EQ]!!
    val MINUS_EQ = TOKENS[LibSLLexer.MINUS_EQ]!!
    val ASTERISK_EQ = TOKENS[LibSLLexer.ASTERISK_EQ]!!
    val SLASH_EQ = TOKENS[LibSLLexer.SLASH_EQ]!!
    val PERCENT_EQ = TOKENS[LibSLLexer.PERCENT_EQ]!!
    val EXCLAMATION = TOKENS[LibSLLexer.EXCLAMATION]!!
    val EXCLAMATION_EQ = TOKENS[LibSLLexer.EXCLAMATION_EQ]!!
    val L_ARROW_EQ = TOKENS[LibSLLexer.L_ARROW_EQ]!!
    val R_ARROW_EQ = TOKENS[LibSLLexer.R_ARROW_EQ]!!
    val AMPERSAND = TOKENS[LibSLLexer.AMPERSAND]!!
    val DOUBLE_AMPERSAND = TOKENS[LibSLLexer.DOUBLE_AMPERSAND]!!
    val BIT_OR = TOKENS[LibSLLexer.BIT_OR]!!
    val LOGIC_OR = TOKENS[LibSLLexer.LOGIC_OR]!!
    val XOR = TOKENS[LibSLLexer.XOR]!!
    val TILDE = TOKENS[LibSLLexer.TILDE]!!
    val AMPERSAND_EQ = TOKENS[LibSLLexer.AMPERSAND_EQ]!!
    val OR_EQ = TOKENS[LibSLLexer.OR_EQ]!!
    val XOR_EQ = TOKENS[LibSLLexer.XOR_EQ]!!
    val R_SHIFT_EQ = TOKENS[LibSLLexer.R_SHIFT_EQ]!!
    val L_SHIFT_EQ = TOKENS[LibSLLexer.L_SHIFT_EQ]!!
    val APOSTROPHE = TOKENS[LibSLLexer.APOSTROPHE]!!
    val BACK_QOUTE = TOKENS[LibSLLexer.BACK_QOUTE]!!

    //Strings
    val ImportStatement = TOKENS[LibSLLexer.ImportStatement]!!
    val IncludeStatement = TOKENS[LibSLLexer.IncludeStatement]!!
    val IMPORT = TOKENS[LibSLLexer.IMPORT]!!
    val INCLUDE = TOKENS[LibSLLexer.INCLUDE]!!
    val LIBSL = TOKENS[LibSLLexer.LIBSL]!!
    val LIBRARY = TOKENS[LibSLLexer.LIBRARY]!!
    val VERSION = TOKENS[LibSLLexer.VERSION]!!
    val LANGUAGE = TOKENS[LibSLLexer.LANGUAGE]!!
    val URL = TOKENS[LibSLLexer.URL]!!
    val TYPEALIAS = TOKENS[LibSLLexer.TYPEALIAS]!!
    val TYPE = TOKENS[LibSLLexer.TYPE]!!
    val TYPES = TOKENS[LibSLLexer.TYPES]!!
    val ENUM = TOKENS[LibSLLexer.ENUM]!!
    val ANNOTATION = TOKENS[LibSLLexer.ANNOTATION]!!
    val AUTOMATON = TOKENS[LibSLLexer.AUTOMATON]!!
    val CONCEPT = TOKENS[LibSLLexer.CONCEPT]!!
    val VAR = TOKENS[LibSLLexer.VAR]!!
    val VAL = TOKENS[LibSLLexer.VAL]!!
    val INITSTATE = TOKENS[LibSLLexer.INITSTATE]!!
    val STATE = TOKENS[LibSLLexer.STATE]!!
    val FINISHSTATE = TOKENS[LibSLLexer.FINISHSTATE]!!
    val SHIFT = TOKENS[LibSLLexer.SHIFT]!!
    val NEW = TOKENS[LibSLLexer.NEW]!!
    val FUN = TOKENS[LibSLLexer.FUN]!!
    val CONSTRUCTOR = TOKENS[LibSLLexer.CONSTRUCTOR]!!
    val DESTRUCTOR = TOKENS[LibSLLexer.DESTRUCTOR]!!
    val PROC = TOKENS[LibSLLexer.PROC]!!
    val AT = TOKENS[LibSLLexer.AT]!!
    val ACTION = TOKENS[LibSLLexer.ACTION]!!
    val REQUIRES = TOKENS[LibSLLexer.REQUIRES]!!
    val ENSURES = TOKENS[LibSLLexer.ENSURES]!!
    val ASSIGNS = TOKENS[LibSLLexer.ASSIGNS]!!
    val TRUE = TOKENS[LibSLLexer.TRUE]!!
    val FALSE = TOKENS[LibSLLexer.FALSE]!!
    val DEFINE = TOKENS[LibSLLexer.DEFINE]!!
    val IF = TOKENS[LibSLLexer.IF]!!
    val ELSE = TOKENS[LibSLLexer.ELSE]!!
    val BY = TOKENS[LibSLLexer.BY]!!
    val IS = TOKENS[LibSLLexer.IS]!!
    val AS = TOKENS[LibSLLexer.AS]!!
    val NULL = TOKENS[LibSLLexer.NULL]!!
    val Identifier = TOKENS[LibSLLexer.Identifier]!!
    val DoubleQuotedString = TOKENS[LibSLLexer.DoubleQuotedString]!!
    val Digit = TOKENS[LibSLLexer.Digit]!!
    val NEWLINE = TOKENS[LibSLLexer.NEWLINE]!!

    //val NEWLINE = TOKENS[LibSLLexer.NEWLINE]!!
    val WS = TOKENS[LibSLLexer.WS]!!
    val BR = TOKENS[LibSLLexer.BR]!!
    public val COMMENT = TOKENS[LibSLLexer.COMMENT]!!
    val LINE_COMMENT = TOKENS[LibSLLexer.LINE_COMMENT]!!

    object Factory {
        private val LOGGER: Logger = Logger.getInstance(Factory::class.java)

        private val labeledRuleElementTypes: MutableMap<String, IElementType> = mutableMapOf()

        fun getLabeledRuleElementTypes(): Map<String, IElementType> = labeledRuleElementTypes

        private fun createLabeledRuleElement(label: String, prototype: RuleIElementType): LabeledRuleIElementType {
            val ruleElementType = LabeledRuleIElementType.create(label, prototype)
            labeledRuleElementTypes[label] = ruleElementType
            return ruleElementType
        }

        private val RULES = PSIElementTypeFactory.getRuleIElementTypes(LibSLLanguage.Companion.INSTANCE)
        private val actionDecl = RULES[LibSLParser.RULE_actionDecl]
        private val argName = RULES[LibSLParser.RULE_argName]
        private val arrayLiteral = RULES[LibSLParser.RULE_arrayLiteral]
        private val HEADER = RULES[LibSLParser.RULE_header]
        //private val FUNCTION_BODY = RULES[LibSLParser.RULE_functionBody]
        /*private val BLOCK = RULES[LibSLParser.RULE_block]
        private val VARIABLE_STATEMENT = RULES[LibSLParser.RULE_variableStatement]
        private val VARIABLE_DECLARATION_LIST = RULES[LibSLParser.RULE_variableDeclarationList]
        private val VARIABLE_DECLARATION = RULES[LibSLParser.RULE_variableDeclaration]
        private val IMPORT_STATEMENT = RULES[LibSLParser.RULE_importStatement]
        private val EXPORT_STATEMENT = RULES[LibSLParser.RULE_exportStatement]
        private val EXPRESSION_STATEMENT = RULES[LibSLParser.RULE_expressionStatement]
        private val RETURN_STATEMENT = RULES[LibSLParser.RULE_returnStatement]
        private val YIELD_STATEMENT = RULES[LibSLParser.RULE_yieldStatement]
        private val IF_STATEMENT = RULES[LibSLParser.RULE_ifStatement]
        private val ITERATION_STATEMENT = RULES[LibSLParser.RULE_iterationStatement]
        private val DO_STATEMENT = createLabeledRuleElement("DoStatement", ITERATION_STATEMENT)
        private val WHILE_STATEMENT = createLabeledRuleElement("WhileStatement", ITERATION_STATEMENT)
        private val FOR_STATEMENT = createLabeledRuleElement("ForStatement", ITERATION_STATEMENT)
        private val FOR_IN_STATEMENT = createLabeledRuleElement("ForInStatement", ITERATION_STATEMENT)
        private val FOR_OF_STATEMENT = createLabeledRuleElement("ForOfStatement", ITERATION_STATEMENT)
        private val WITH_STATEMENT = RULES[LibSLParser.RULE_withStatement]
        private val DEBUGGER_STATEMENT = RULES[LibSLParser.RULE_debuggerStatement]
        private val PARAMETERS = RULES[LibSLParser.RULE_formalParameterList]
        private val PARAMETER = RULES[LibSLParser.RULE_formalParameterArg]
        private val REST_PARAMETER = RULES[LibSLParser.RULE_lastFormalParameterArg]
        private val EXPRESSION_SEQUENCE = RULES[LibSLParser.RULE_expressionSequence]
        private val EXPRESSION = RULES[LibSLParser.RULE_singleExpression]
        private val ARGUMENTS_EXPRESSION = createLabeledRuleElement("ArgumentsExpression", EXPRESSION)
        private val POST_INCREMENT_EXPRESSION = createLabeledRuleElement("PostIncrementExpression", EXPRESSION)
        private val POST_DECREASE_EXPRESSION = createLabeledRuleElement("PostDecreaseExpression", EXPRESSION)
        private val PRE_INCREMENT_EXPRESSION = createLabeledRuleElement("PreIncrementExpression", EXPRESSION)
        private val PRE_DECREASE_EXPRESSION = createLabeledRuleElement("PreDecreaseExpression", EXPRESSION)
        private val IDENTIFIER_EXPRESSION = createLabeledRuleElement("IdentifierExpression", EXPRESSION)
        private val ASSIGNMENT_EXPRESSION = createLabeledRuleElement("AssignmentExpression", EXPRESSION)
        private val MEMBER_DOT_EXPRESSION = createLabeledRuleElement("MemberDotExpression", EXPRESSION)
        private val ARGUMENTS = RULES[LibSLParser.RULE_arguments]
        private val ARGUMENT = RULES[LibSLParser.RULE_argument]
        private val OBJECT = RULES[LibSLParser.RULE_objectLiteral]
        private val ARRAY = RULES[LibSLParser.RULE_arrayLiteral]
        private val PROPERTY_ASSIGNMENT = RULES[LibSLParser.RULE_propertyAssignment]
        private val PROPERTY_EXPRESSION_ASSIGNMENT = createLabeledRuleElement("PropertyExpressionAssignment", PROPERTY_ASSIGNMENT)
        private val COMPUTED_PROPERTY_EXPRESSION_ASSIGNMENT = createLabeledRuleElement("ComputedPropertyExpressionAssignment", PROPERTY_ASSIGNMENT)
        private val FUNCTION_PROPERTY = createLabeledRuleElement("FunctionProperty", PROPERTY_ASSIGNMENT)
        private val PROPERTY_GETTER = createLabeledRuleElement("PropertyGetter", PROPERTY_ASSIGNMENT)
        private val PROPERTY_SETTER = createLabeledRuleElement("PropertySetter", PROPERTY_ASSIGNMENT)
        private val PROPERTY_SHORTHAND = createLabeledRuleElement("PropertyShorthand", PROPERTY_ASSIGNMENT)
        private val TEMPLATE_STRING = RULES[LibSLParser.RULE_templateStringLiteral]
        private val ANONYMOUS_FUNCTION = RULES[LibSLParser.RULE_anonymousFunction]
        private val CLASS_DECLARATION = RULES[LibSLParser.RULE_classDeclaration]
        private val CLASS_ELEMENT = RULES[LibSLParser.RULE_classElement]
        private val CLASS_ELEMENT_NAME = RULES[LibSLParser.RULE_classElementName]
        private val METHOD_DEFINITION = RULES[LibSLParser.RULE_methodDefinition]
        private val FIELD_DEFINITION = RULES[LibSLParser.RULE_fieldDefinition]
        private val PROPERTY_NAME = RULES[LibSLParser.RULE_propertyName]
        private val LABELED_STATEMENT = RULES[LibSLParser.RULE_labelledStatement]
        private val BREAK_STATEMENT = RULES[LibSLParser.RULE_breakStatement]
        private val CONTINUE_STATEMENT = RULES[LibSLParser.RULE_continueStatement]
        private val THROW_STATEMENT = RULES[LibSLParser.RULE_throwStatement]
        private val TRY_STATEMENT = RULES[LibSLParser.RULE_tryStatement]
        private val CATCH = RULES[LibSLParser.RULE_catchProduction]
        private val FINALLY = RULES[LibSLParser.RULE_finallyProduction]
        private val SWITCH = RULES[LibSLParser.RULE_switchStatement]
        private val CASE_BLOCK = RULES[LibSLParser.RULE_caseBlock]
        private val CASE = RULES[LibSLParser.RULE_caseClause]
        private val DEFAULT_CASE = RULES[LibSLParser.RULE_defaultClause]*/

        fun createElement(node: ASTNode): PsiElement {
            return when (node.elementType) {
                HEADER -> LibSLHeader(node)
                /*IDENTIFIER_NAME -> JavaScriptIdentifierName(node)
                LITERAL -> JavaScriptLiteral(node)
                FUNCTION_DECLARATION -> JavaScriptFunctionDeclaration(node)
                FUNCTION_BODY -> JavaScriptFunctionBody(node)
                BLOCK -> JavaScriptBlock(node)
                VARIABLE_STATEMENT -> JavaScriptVariableStatement(node)
                VARIABLE_DECLARATION_LIST -> JavaScriptVariableDeclarationList(node)
                VARIABLE_DECLARATION -> JavaScriptVariableDeclaration(node)
                IMPORT_STATEMENT -> JavaScriptImportStatement(node)
                EXPORT_STATEMENT -> JavaScriptExportStatement(node)
                EXPRESSION_STATEMENT -> JavaScriptExpressionStatement(node)
                RETURN_STATEMENT -> JavaScriptReturnStatement(node)
                YIELD_STATEMENT -> JavaScriptYieldStatement(node)
                IF_STATEMENT -> JavaScriptIfStatement(node)
                ITERATION_STATEMENT -> unexpectedNode(node)
                DO_STATEMENT -> JavaScriptDoWhileStatement(node)
                WHILE_STATEMENT -> JavaScriptWhileStatement(node)
                FOR_STATEMENT -> JavaScriptForStatement(node)
                FOR_IN_STATEMENT -> JavaScriptForInStatement(node)
                FOR_OF_STATEMENT -> JavaScriptForOfStatement(node)
                WITH_STATEMENT -> JavaScriptWithStatement(node)
                DEBUGGER_STATEMENT -> JavaScriptDebuggerStatement(node)
                PARAMETERS -> JavaScriptParameters(node)
                PARAMETER -> JavaScriptFormalParameter(node)
                REST_PARAMETER -> JavaScriptFormalRestParameter(node)
                EXPRESSION_SEQUENCE -> JavaScriptExpressionSequence(node)
                EXPRESSION -> JavaScriptExpression.Other(node)
                ARGUMENTS_EXPRESSION -> JavaScriptCallExpression(node)
                POST_INCREMENT_EXPRESSION -> JavaScriptUpdateExpression(node)
                POST_DECREASE_EXPRESSION -> JavaScriptUpdateExpression(node)
                PRE_INCREMENT_EXPRESSION -> JavaScriptUpdateExpression(node)
                PRE_DECREASE_EXPRESSION -> JavaScriptUpdateExpression(node)
                IDENTIFIER_EXPRESSION -> JavaScriptIdentifierExpression(node)
                ASSIGNMENT_EXPRESSION -> JavaScriptAssignmentExpression(node)
                MEMBER_DOT_EXPRESSION -> JavaScriptMemberDotExpression(node)
                ARGUMENTS -> JavaScriptArguments(node)
                ARGUMENT -> JavaScriptArgument(node)
                OBJECT -> JavaScriptObject(node)
                ARRAY -> JavaScriptArray(node)
                PROPERTY_ASSIGNMENT -> unexpectedNode(node)
                PROPERTY_EXPRESSION_ASSIGNMENT -> JavaScriptPropertyExpressionAssignment(node)
                COMPUTED_PROPERTY_EXPRESSION_ASSIGNMENT -> JavaScriptComputedPropertyExpressionAssignment(node)
                FUNCTION_PROPERTY -> JavaScriptFunctionProperty(node)
                PROPERTY_GETTER -> JavaScriptPropertyGetter(node)
                PROPERTY_SETTER -> JavaScriptPropertySetter(node)
                PROPERTY_SHORTHAND -> JavaScriptPropertyShorthand(node)
                TEMPLATE_STRING -> JavaScriptTemplateString(node)
                ANONYMOUS_FUNCTION -> JavaScriptAnonymousFunction(node)
                CLASS_DECLARATION -> JavaScriptClassDeclaration(node)
                //CLASS_ELEMENT -> createClassElement(node)
                CLASS_ELEMENT_NAME -> JavaScriptClassElementName(node)
                METHOD_DEFINITION -> JavaScriptMethodDefinition(node)
                FIELD_DEFINITION -> JavaScriptFieldDefinition(node)
                PROPERTY_NAME -> JavaScriptPropertyName(node)
                LABELED_STATEMENT -> JavaScriptLabeledStatement(node)
                BREAK_STATEMENT -> JavaScriptBreakStatement(node)
                CONTINUE_STATEMENT -> JavaScriptContinueStatement(node)
                THROW_STATEMENT -> JavaScriptThrowStatement(node)
                TRY_STATEMENT -> JavaScriptTryStatement(node)
                CATCH -> JavaScriptCatch(node)
                FINALLY -> JavaScriptFinally(node)
                SWITCH -> JavaScriptSwitchStatement(node)
                CASE_BLOCK -> JavaScriptCaseBlock(node)
                CASE -> JavaScriptCaseClause(node)
                DEFAULT_CASE -> JavaScriptDefaultClause(node)*/
                //TODO: other rules
                else -> ASTWrapperPsiElement(node)
            }
        }

        private fun unexpectedNode(node: ASTNode): PsiElement {
            LOGGER.warn("Unexpected node $node")
            return ASTWrapperPsiElement(node)
        }

        /*private fun createClassElement(node: ASTNode): PsiElement {
            return when (node.lastChildNode?.psi) {
                is JavaScriptMethodDefinition -> JavaScriptMethod(node)
                is JavaScriptFieldDefinition -> JavaScriptField(node)
                is JavaScriptBlock -> JavaScriptClassStaticBlock(node)
                else -> ASTWrapperPsiElement(node)
            }
        }*/
    }
}