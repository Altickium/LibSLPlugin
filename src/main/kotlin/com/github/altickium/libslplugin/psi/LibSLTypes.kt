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
import com.github.altickium.libslplugin.psi.parserrules.*

object LibSLTypes {
    init {
        PSIElementTypeFactory.defineLanguageIElementTypes(
            LibSLLanguage.Companion.INSTANCE, LibSLLexer.tokenNames, LibSLParser.ruleNames
        )
    }

    val FILE = IFileElementType(LibSLLanguage.Companion.INSTANCE)

    private val TOKENS = PSIElementTypeFactory.getTokenIElementTypes(LibSLLanguage.Companion.INSTANCE)
    val SEMICOLON = TOKENS[LibSLLexer.SEMICOLON]!!

    //Braces
    val L_BRACE = TOKENS[LibSLLexer.L_BRACE]!!
    val R_BRACE = TOKENS[LibSLLexer.R_BRACE]!!
    val L_BRACKET = TOKENS[LibSLLexer.L_BRACKET]!!
    val R_BRACKET = TOKENS[LibSLLexer.R_BRACKET]!!
    val L_SQUARE_BRACKET = TOKENS[LibSLLexer.L_SQUARE_BRACKET]!!
    val R_SQUARE_BRACKET = TOKENS[LibSLLexer.R_SQUARE_BRACKET]!!
    val DOT = TOKENS[LibSLLexer.DOT]!!
    val COLON = TOKENS[LibSLLexer.COLON]!!
    val COMMA = TOKENS[LibSLLexer.COMMA]!!

    //Op
    //Op
    val ASSIGN_OP = TOKENS[LibSLLexer.ASSIGN_OP]!!
    val EQ = TOKENS[LibSLLexer.EQ]!!
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

    //EOL
    val NEWLINE = TOKENS[LibSLLexer.NEWLINE]!!
    val WS = TOKENS[LibSLLexer.WS]!!
    val BR = TOKENS[LibSLLexer.BR]!!
    val COMMENT = TOKENS[LibSLLexer.COMMENT]!!
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

        //
        private val file = RULES[LibSLParser.RULE_file]
        private val globalStatement = RULES[LibSLParser.RULE_globalStatement]
        private val topLevelDecl = RULES[LibSLParser.RULE_topLevelDecl]
        private val header = RULES[LibSLParser.RULE_header]
        private val typealiasStatement = RULES[LibSLParser.RULE_typealiasStatement]
        private val typeDefBlock = RULES[LibSLParser.RULE_typeDefBlock]
        private val targetType = RULES[LibSLParser.RULE_targetType]
        private val typeList = RULES[LibSLParser.RULE_typeList]
        private val typeDefBlockStatement = RULES[LibSLParser.RULE_typeDefBlockStatement]
        private val enumBlock = RULES[LibSLParser.RULE_enumBlock]
        private val enumBlockStatement = RULES[LibSLParser.RULE_enumBlockStatement]

        //Semantic types
        private val typesSection = RULES[LibSLParser.RULE_typesSection]
        private val semanticTypeDecl = RULES[LibSLParser.RULE_semanticTypeDecl]

        //Simple semantic type
        private val simpleSemanticType = RULES[LibSLParser.RULE_simpleSemanticType]
        private val enumSemanticType = RULES[LibSLParser.RULE_enumSemanticType]
        private val enumSemanticTypeEntry = RULES[LibSLParser.RULE_enumSemanticTypeEntry]
        private val annotationDecl = RULES[LibSLParser.RULE_annotationDecl]
        private val annotationDeclParams = RULES[LibSLParser.RULE_annotationDeclParams]
        private val annotationDeclParamsPart = RULES[LibSLParser.RULE_annotationDeclParamsPart]
        private val actionDecl = RULES[LibSLParser.RULE_actionDecl]
        private val actionDeclParamList = RULES[LibSLParser.RULE_actionDeclParamList]
        private val actionParameter = RULES[LibSLParser.RULE_actionParameter]
        private val automatonDecl = RULES[LibSLParser.RULE_automatonDecl]
        private val constructorVariables = RULES[LibSLParser.RULE_constructorVariables]
        private val automatonStatement = RULES[LibSLParser.RULE_automatonStatement]
        private val implementedConcepts = RULES[LibSLParser.RULE_implementedConcepts]
        private val concept = RULES[LibSLParser.RULE_concept]
        private val automatonStateDecl = RULES[LibSLParser.RULE_automatonStateDecl]
        private val automatonShiftDecl = RULES[LibSLParser.RULE_automatonShiftDecl]
        private val functionsList = RULES[LibSLParser.RULE_functionsList]
        private val functionsListPart = RULES[LibSLParser.RULE_functionsListPart]
        private val variableDecl = RULES[LibSLParser.RULE_variableDecl]
        private val nameWithType = RULES[LibSLParser.RULE_nameWithType]
        private val typeIdentifier = RULES[LibSLParser.RULE_typeIdentifier]
        private val generic = RULES[LibSLParser.RULE_generic]
        private val variableAssignment = RULES[LibSLParser.RULE_variableAssignment]
        private val assignmentRight = RULES[LibSLParser.RULE_assignmentRight]
        private val callAutomatonConstructorWithNamedArgs = RULES[LibSLParser.RULE_callAutomatonConstructorWithNamedArgs]
        private val namedArgs = RULES[LibSLParser.RULE_namedArgs]
        private val argPair = RULES[LibSLParser.RULE_argPair]
        private val headerWithAsterisk = RULES[LibSLParser.RULE_headerWithAsterisk]
        private val constructorDecl = RULES[LibSLParser.RULE_constructorDecl]
        private val constructorHeader = RULES[LibSLParser.RULE_constructorHeader]
        private val destructorDecl = RULES[LibSLParser.RULE_destructorDecl]
        private val destructorHeader = RULES[LibSLParser.RULE_destructorHeader]
        private val procDecl = RULES[LibSLParser.RULE_procDecl]
        private val procHeader = RULES[LibSLParser.RULE_procHeader]

        //Function
        private val functionDecl = RULES[LibSLParser.RULE_functionDecl]
        private val functionHeader = RULES[LibSLParser.RULE_functionHeader]
        private val functionDeclArgList = RULES[LibSLParser.RULE_functionDeclArgList]
        private val parameter = RULES[LibSLParser.RULE_parameter]
        //Annotation
        private val annotationUsage = RULES[LibSLParser.RULE_annotationUsage]
        private val functionContract = RULES[LibSLParser.RULE_functionContract]
        private val functionBody = RULES[LibSLParser.RULE_functionBody]
        private val functionBodyStatement = RULES[LibSLParser.RULE_functionBodyStatement]
        private val ifStatement = RULES[LibSLParser.RULE_ifStatement]
        private val elseStatement = RULES[LibSLParser.RULE_elseStatement]

        //Semantic action
        private val actionUsage = RULES[LibSLParser.RULE_actionUsage]
        private val procUsage = RULES[LibSLParser.RULE_procUsage]
        private val funUsage = RULES[LibSLParser.RULE_funUsage]
        private val expressionsList = RULES[LibSLParser.RULE_expressionsList]
        private val annotationArgs = RULES[LibSLParser.RULE_annotationArgs]
        private val argName = RULES[LibSLParser.RULE_argName]
        //Contracts
        private val requiresContract = RULES[LibSLParser.RULE_requiresContract]
        private val ensuresContract = RULES[LibSLParser.RULE_ensuresContract]
        private val assignsContract = RULES[LibSLParser.RULE_assignsContract]

        //Expression
        private val expression = RULES[LibSLParser.RULE_expression]
        private val hasAutomatonConcept = RULES[LibSLParser.RULE_hasAutomatonConcept]
        private val bitShiftOp = RULES[LibSLParser.RULE_bitShiftOp]
        private val lShift = RULES[LibSLParser.RULE_lShift]
        private val rShift = RULES[LibSLParser.RULE_rShift]
        private val uRShift = RULES[LibSLParser.RULE_uRShift]
        private val uLShift = RULES[LibSLParser.RULE_uLShift]
        private val unaryOp = RULES[LibSLParser.RULE_unaryOp]
        private val expressionAtomic = RULES[LibSLParser.RULE_expressionAtomic]
        private val primitiveLiteral = RULES[LibSLParser.RULE_primitiveLiteral]
        private val qualifiedAccess = RULES[LibSLParser.RULE_qualifiedAccess]
        private val simpleCall = RULES[LibSLParser.RULE_simpleCall]
        private val identifierList = RULES[LibSLParser.RULE_identifierList]
        private val arrayLiteral = RULES[LibSLParser.RULE_arrayLiteral]
        private val periodSeparatedFullName = RULES[LibSLParser.RULE_periodSeparatedFullName]
        private val integerNumber = RULES[LibSLParser.RULE_integerNumber]
        private val floatNumber = RULES[LibSLParser.RULE_floatNumber]
        private val identifierRule = RULES[LibSLParser.RULE_identifierRule]

        fun createElement(node: ASTNode): PsiElement {
            return when (node.elementType) {
                file -> LibSLFileRule(node)
                globalStatement -> LibSLGlobalStatement(node)
                topLevelDecl -> LibSLTopLevelDecl(node)
                header -> LibSLHeader(node)
                typealiasStatement -> LibSLTypealiasStatement(node)
                typeDefBlock -> LibSLTypeDefBlock(node)
                targetType -> LibSLTargetType(node)
                typeList -> LibSLTypeList(node)
                typeDefBlockStatement -> LibSLTypeDefBlockStatement(node)
                enumBlock -> LibSLEnumBlock(node)
                enumBlockStatement -> LibSLEnumBlockStatement(node)
                typesSection -> LibSLTypesSection(node)
                semanticTypeDecl -> LibSLSemanticTypeDecl(node)
                simpleSemanticType -> LibSLSimpleSemanticType(node)
                enumSemanticType -> LibSLEnumSemanticType(node)
                enumSemanticTypeEntry -> LibSLEnumSemanticTypeEntry(node)
                annotationDecl -> LibSLAnnotationDecl(node)
                annotationDeclParams -> LibSLAnnotationDeclParams(node)
                annotationDeclParamsPart -> LibSLAnnotationDeclParamsPart(node)
                actionDecl -> LibSLActionDecl(node)
                actionDeclParamList -> LibSLActionDeclParamList(node)
                actionParameter -> LibSLActionParameter(node)
                automatonDecl -> LibSLAutomatonDecl(node)
                constructorVariables -> LibSLConstructorVariables(node)
                automatonStatement -> LibSLAutomatonStatement(node)
                implementedConcepts -> LibSLImplementedConcepts(node)
                concept -> LibSLConcept(node)
                automatonStateDecl -> LibSLAutomatonStateDecl(node)
                automatonShiftDecl -> LibSLAutomatonShiftDecl(node)
                functionsList -> LibSLFunctionsList(node)
                functionsListPart -> LibSLFunctionsListPart(node)
                variableDecl -> LibSLVariableDecl(node)
                nameWithType -> LibSLNameWithType(node)
                typeIdentifier -> LibSLTypeIdentifier(node)
                generic -> LibSLGeneric(node)
                variableAssignment -> LibSLVariableAssignment(node)
                assignmentRight -> LibSLAssignmentRight(node)
                callAutomatonConstructorWithNamedArgs -> LibSLCallAutomatonConstructorWithNamedArgs(node)
                namedArgs -> LibSLNamedArgs(node)
                argPair -> LibSLArgPair(node)
                headerWithAsterisk -> LibSLHeaderWithAsterisk(node)
                constructorDecl -> LibSLConstructorDecl(node)
                constructorHeader -> LibSLConstructorHeader(node)
                destructorDecl -> LibSLDestructorDecl(node)
                destructorHeader -> LibSLDestructorHeader(node)
                procDecl -> LibSLProcDecl(node)
                procHeader -> LibSLProcHeader(node)
                functionDecl -> LibSLFunctionDecl(node)
                functionHeader -> LibSLFunctionHeader(node)
                functionDeclArgList -> LibSLFunctionDeclArgList(node)
                parameter -> LibSLParameter(node)
                annotationUsage -> LibSLAnnotationUsage(node)
                functionContract -> LibSLFunctionContract(node)
                functionBody -> LibSLFunctionBody(node)
                functionBodyStatement -> LibSLFunctionBodyStatement(node)
                ifStatement -> LibSLIfStatement(node)
                elseStatement -> LibSLElseStatement(node)
                actionUsage -> LibSLActionUsage(node)
                procUsage -> LibSLProcUsage(node)
                funUsage -> LibSLFunUsage(node)
                expressionsList -> LibSLExpressionsList(node)
                annotationArgs -> LibSLAnnotationArgs(node)
                argName -> LibSLArgName(node)
                requiresContract -> LibSLRequiresContract(node)
                ensuresContract -> LibSLEnsuresContract(node)
                assignsContract -> LibSLAssignsContract(node)
                expression -> LibSLExpression(node)
                hasAutomatonConcept -> LibSLHsAutomatonConcept(node)
                bitShiftOp -> LibSLBitShiftOp(node)
                lShift -> LibSLLShift(node)
                rShift -> LibSLRShift(node)
                uRShift -> LibSLURShift(node)
                uLShift -> LibSLULShift(node)
                unaryOp -> LibSLUnaryOp(node)
                expressionAtomic -> LibSLExpressionAtomic(node)
                primitiveLiteral -> LibSLPrimitiveLiteral(node)
                qualifiedAccess -> LibSLQualifiedAccess(node)
                simpleCall -> LibSLSimpleCall(node)
                identifierList -> LibSLIdentifierList(node)
                arrayLiteral -> LibSLArrayLiteral(node)
                periodSeparatedFullName -> LibSLPeriodSeparatedFullName(node)
                integerNumber -> LibSLIntegerNumber(node)
                floatNumber -> LibSLFloatNumber(node)
                identifierRule -> LibSLIdentifierRule(node)
                else -> ASTWrapperPsiElement(node)
            }
        }

        private fun unexpectedNode(node: ASTNode): PsiElement {
            LOGGER.warn("Unexpected node $node")
            return ASTWrapperPsiElement(node)
        }

        /*private fun createClassElement(node: ASTNode): PsiElement {
            return when (node.lastChildNode?.psi) {
                is LibSLAutomatonDecl -> STUB_CLASS(node)
                else -> ASTWrapperPsiElement(node)
            }
        }*/
    }
}