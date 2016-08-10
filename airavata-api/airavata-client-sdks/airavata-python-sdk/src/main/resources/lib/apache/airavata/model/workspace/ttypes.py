#
# Autogenerated by Thrift Compiler (0.9.3)
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#
#  options string: py
#

from thrift.Thrift import TType, TMessageType, TException, TApplicationException
import apache.airavata.model.commons.ttypes


from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol, TProtocol
try:
  from thrift.protocol import fastbinary
except:
  fastbinary = None


class GatewayApprovalStatus:
  REQUESTED = 0
  APPROVED = 1
  ACTIVE = 2
  DEACTIVATED = 3
  CANCELLED = 4
  DENIED = 5

  _VALUES_TO_NAMES = {
    0: "REQUESTED",
    1: "APPROVED",
    2: "ACTIVE",
    3: "DEACTIVATED",
    4: "CANCELLED",
    5: "DENIED",
  }

  _NAMES_TO_VALUES = {
    "REQUESTED": 0,
    "APPROVED": 1,
    "ACTIVE": 2,
    "DEACTIVATED": 3,
    "CANCELLED": 4,
    "DENIED": 5,
  }

class NotificationPriority:
  LOW = 0
  NORMAL = 1
  HIGH = 2

  _VALUES_TO_NAMES = {
    0: "LOW",
    1: "NORMAL",
    2: "HIGH",
  }

  _NAMES_TO_VALUES = {
    "LOW": 0,
    "NORMAL": 1,
    "HIGH": 2,
  }


class Group:
  """
  Attributes:
   - groupName
   - description
  """

  thrift_spec = (
    None, # 0
    (1, TType.STRING, 'groupName', None, None, ), # 1
    (2, TType.STRING, 'description', None, None, ), # 2
  )

  def __init__(self, groupName=None, description=None,):
    self.groupName = groupName
    self.description = description

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == 1:
        if ftype == TType.STRING:
          self.groupName = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 2:
        if ftype == TType.STRING:
          self.description = iprot.readString()
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('Group')
    if self.groupName is not None:
      oprot.writeFieldBegin('groupName', TType.STRING, 1)
      oprot.writeString(self.groupName)
      oprot.writeFieldEnd()
    if self.description is not None:
      oprot.writeFieldBegin('description', TType.STRING, 2)
      oprot.writeString(self.description)
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def validate(self):
    if self.groupName is None:
      raise TProtocol.TProtocolException(message='Required field groupName is unset!')
    return


  def __hash__(self):
    value = 17
    value = (value * 31) ^ hash(self.groupName)
    value = (value * 31) ^ hash(self.description)
    return value

  def __repr__(self):
    L = ['%s=%r' % (key, value)
      for key, value in self.__dict__.iteritems()]
    return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)

class Project:
  """
  Attributes:
   - projectID
   - owner
   - gatewayId
   - name
   - description
   - creationTime
   - sharedUsers
   - sharedGroups
  """

  thrift_spec = (
    None, # 0
    (1, TType.STRING, 'projectID', None, "DO_NOT_SET_AT_CLIENTS", ), # 1
    (2, TType.STRING, 'owner', None, None, ), # 2
    (3, TType.STRING, 'gatewayId', None, None, ), # 3
    (4, TType.STRING, 'name', None, None, ), # 4
    (5, TType.STRING, 'description', None, None, ), # 5
    (6, TType.I64, 'creationTime', None, None, ), # 6
    (7, TType.LIST, 'sharedUsers', (TType.STRING,None), None, ), # 7
    (8, TType.LIST, 'sharedGroups', (TType.STRING,None), None, ), # 8
  )

  def __init__(self, projectID=thrift_spec[1][4], owner=None, gatewayId=None, name=None, description=None, creationTime=None, sharedUsers=None, sharedGroups=None,):
    self.projectID = projectID
    self.owner = owner
    self.gatewayId = gatewayId
    self.name = name
    self.description = description
    self.creationTime = creationTime
    self.sharedUsers = sharedUsers
    self.sharedGroups = sharedGroups

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == 1:
        if ftype == TType.STRING:
          self.projectID = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 2:
        if ftype == TType.STRING:
          self.owner = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 3:
        if ftype == TType.STRING:
          self.gatewayId = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 4:
        if ftype == TType.STRING:
          self.name = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 5:
        if ftype == TType.STRING:
          self.description = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 6:
        if ftype == TType.I64:
          self.creationTime = iprot.readI64()
        else:
          iprot.skip(ftype)
      elif fid == 7:
        if ftype == TType.LIST:
          self.sharedUsers = []
          (_etype3, _size0) = iprot.readListBegin()
          for _i4 in xrange(_size0):
            _elem5 = iprot.readString()
            self.sharedUsers.append(_elem5)
          iprot.readListEnd()
        else:
          iprot.skip(ftype)
      elif fid == 8:
        if ftype == TType.LIST:
          self.sharedGroups = []
          (_etype9, _size6) = iprot.readListBegin()
          for _i10 in xrange(_size6):
            _elem11 = iprot.readString()
            self.sharedGroups.append(_elem11)
          iprot.readListEnd()
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('Project')
    if self.projectID is not None:
      oprot.writeFieldBegin('projectID', TType.STRING, 1)
      oprot.writeString(self.projectID)
      oprot.writeFieldEnd()
    if self.owner is not None:
      oprot.writeFieldBegin('owner', TType.STRING, 2)
      oprot.writeString(self.owner)
      oprot.writeFieldEnd()
    if self.gatewayId is not None:
      oprot.writeFieldBegin('gatewayId', TType.STRING, 3)
      oprot.writeString(self.gatewayId)
      oprot.writeFieldEnd()
    if self.name is not None:
      oprot.writeFieldBegin('name', TType.STRING, 4)
      oprot.writeString(self.name)
      oprot.writeFieldEnd()
    if self.description is not None:
      oprot.writeFieldBegin('description', TType.STRING, 5)
      oprot.writeString(self.description)
      oprot.writeFieldEnd()
    if self.creationTime is not None:
      oprot.writeFieldBegin('creationTime', TType.I64, 6)
      oprot.writeI64(self.creationTime)
      oprot.writeFieldEnd()
    if self.sharedUsers is not None:
      oprot.writeFieldBegin('sharedUsers', TType.LIST, 7)
      oprot.writeListBegin(TType.STRING, len(self.sharedUsers))
      for iter12 in self.sharedUsers:
        oprot.writeString(iter12)
      oprot.writeListEnd()
      oprot.writeFieldEnd()
    if self.sharedGroups is not None:
      oprot.writeFieldBegin('sharedGroups', TType.LIST, 8)
      oprot.writeListBegin(TType.STRING, len(self.sharedGroups))
      for iter13 in self.sharedGroups:
        oprot.writeString(iter13)
      oprot.writeListEnd()
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def validate(self):
    if self.projectID is None:
      raise TProtocol.TProtocolException(message='Required field projectID is unset!')
    if self.owner is None:
      raise TProtocol.TProtocolException(message='Required field owner is unset!')
    if self.gatewayId is None:
      raise TProtocol.TProtocolException(message='Required field gatewayId is unset!')
    if self.name is None:
      raise TProtocol.TProtocolException(message='Required field name is unset!')
    return


  def __hash__(self):
    value = 17
    value = (value * 31) ^ hash(self.projectID)
    value = (value * 31) ^ hash(self.owner)
    value = (value * 31) ^ hash(self.gatewayId)
    value = (value * 31) ^ hash(self.name)
    value = (value * 31) ^ hash(self.description)
    value = (value * 31) ^ hash(self.creationTime)
    value = (value * 31) ^ hash(self.sharedUsers)
    value = (value * 31) ^ hash(self.sharedGroups)
    return value

  def __repr__(self):
    L = ['%s=%r' % (key, value)
      for key, value in self.__dict__.iteritems()]
    return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)

class User:
  """
  Attributes:
   - airavataInternalUserId
   - userName
   - gatewayId
   - firstName
   - lastName
   - email
  """

  thrift_spec = (
    None, # 0
    (1, TType.STRING, 'airavataInternalUserId', None, "DO_NOT_SET_AT_CLIENTS", ), # 1
    (2, TType.STRING, 'userName', None, None, ), # 2
    (3, TType.STRING, 'gatewayId', None, None, ), # 3
    (4, TType.STRING, 'firstName', None, None, ), # 4
    (5, TType.STRING, 'lastName', None, None, ), # 5
    (6, TType.STRING, 'email', None, None, ), # 6
  )

  def __init__(self, airavataInternalUserId=thrift_spec[1][4], userName=None, gatewayId=None, firstName=None, lastName=None, email=None,):
    self.airavataInternalUserId = airavataInternalUserId
    self.userName = userName
    self.gatewayId = gatewayId
    self.firstName = firstName
    self.lastName = lastName
    self.email = email

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == 1:
        if ftype == TType.STRING:
          self.airavataInternalUserId = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 2:
        if ftype == TType.STRING:
          self.userName = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 3:
        if ftype == TType.STRING:
          self.gatewayId = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 4:
        if ftype == TType.STRING:
          self.firstName = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 5:
        if ftype == TType.STRING:
          self.lastName = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 6:
        if ftype == TType.STRING:
          self.email = iprot.readString()
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('User')
    if self.airavataInternalUserId is not None:
      oprot.writeFieldBegin('airavataInternalUserId', TType.STRING, 1)
      oprot.writeString(self.airavataInternalUserId)
      oprot.writeFieldEnd()
    if self.userName is not None:
      oprot.writeFieldBegin('userName', TType.STRING, 2)
      oprot.writeString(self.userName)
      oprot.writeFieldEnd()
    if self.gatewayId is not None:
      oprot.writeFieldBegin('gatewayId', TType.STRING, 3)
      oprot.writeString(self.gatewayId)
      oprot.writeFieldEnd()
    if self.firstName is not None:
      oprot.writeFieldBegin('firstName', TType.STRING, 4)
      oprot.writeString(self.firstName)
      oprot.writeFieldEnd()
    if self.lastName is not None:
      oprot.writeFieldBegin('lastName', TType.STRING, 5)
      oprot.writeString(self.lastName)
      oprot.writeFieldEnd()
    if self.email is not None:
      oprot.writeFieldBegin('email', TType.STRING, 6)
      oprot.writeString(self.email)
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def validate(self):
    if self.airavataInternalUserId is None:
      raise TProtocol.TProtocolException(message='Required field airavataInternalUserId is unset!')
    if self.gatewayId is None:
      raise TProtocol.TProtocolException(message='Required field gatewayId is unset!')
    return


  def __hash__(self):
    value = 17
    value = (value * 31) ^ hash(self.airavataInternalUserId)
    value = (value * 31) ^ hash(self.userName)
    value = (value * 31) ^ hash(self.gatewayId)
    value = (value * 31) ^ hash(self.firstName)
    value = (value * 31) ^ hash(self.lastName)
    value = (value * 31) ^ hash(self.email)
    return value

  def __repr__(self):
    L = ['%s=%r' % (key, value)
      for key, value in self.__dict__.iteritems()]
    return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)

class Gateway:
  """
  Attributes:
   - gatewayId
   - gatewayApprovalStatus
   - gatewayName
   - domain
   - emailAddress
   - gatewayAcronym
   - gatewayURL
   - gatewayPublicAbstract
   - reviewProposalDescription
   - gatewayAdminFirstName
   - gatewayAdminLastName
   - gatewayAdminEmail
   - identityServerUserName
   - identityServerPasswordToken
   - declinedReason
   - oauthClientId
   - oauthClientSecret
   - requestCreationTime
  """

  thrift_spec = (
    None, # 0
    (1, TType.STRING, 'gatewayId', None, None, ), # 1
    (2, TType.I32, 'gatewayApprovalStatus', None, None, ), # 2
    (3, TType.STRING, 'gatewayName', None, None, ), # 3
    (4, TType.STRING, 'domain', None, None, ), # 4
    (5, TType.STRING, 'emailAddress', None, None, ), # 5
    (6, TType.STRING, 'gatewayAcronym', None, None, ), # 6
    (7, TType.STRING, 'gatewayURL', None, None, ), # 7
    (8, TType.STRING, 'gatewayPublicAbstract', None, None, ), # 8
    (9, TType.STRING, 'reviewProposalDescription', None, None, ), # 9
    (10, TType.STRING, 'gatewayAdminFirstName', None, None, ), # 10
    (11, TType.STRING, 'gatewayAdminLastName', None, None, ), # 11
    (12, TType.STRING, 'gatewayAdminEmail', None, None, ), # 12
    (13, TType.STRING, 'identityServerUserName', None, None, ), # 13
    (14, TType.STRING, 'identityServerPasswordToken', None, None, ), # 14
    (15, TType.STRING, 'declinedReason', None, None, ), # 15
    (16, TType.STRING, 'oauthClientId', None, None, ), # 16
    (17, TType.STRING, 'oauthClientSecret', None, None, ), # 17
    (18, TType.I64, 'requestCreationTime', None, None, ), # 18
  )

  def __init__(self, gatewayId=None, gatewayApprovalStatus=None, gatewayName=None, domain=None, emailAddress=None, gatewayAcronym=None, gatewayURL=None, gatewayPublicAbstract=None, reviewProposalDescription=None, gatewayAdminFirstName=None, gatewayAdminLastName=None, gatewayAdminEmail=None, identityServerUserName=None, identityServerPasswordToken=None, declinedReason=None, oauthClientId=None, oauthClientSecret=None, requestCreationTime=None,):
    self.gatewayId = gatewayId
    self.gatewayApprovalStatus = gatewayApprovalStatus
    self.gatewayName = gatewayName
    self.domain = domain
    self.emailAddress = emailAddress
    self.gatewayAcronym = gatewayAcronym
    self.gatewayURL = gatewayURL
    self.gatewayPublicAbstract = gatewayPublicAbstract
    self.reviewProposalDescription = reviewProposalDescription
    self.gatewayAdminFirstName = gatewayAdminFirstName
    self.gatewayAdminLastName = gatewayAdminLastName
    self.gatewayAdminEmail = gatewayAdminEmail
    self.identityServerUserName = identityServerUserName
    self.identityServerPasswordToken = identityServerPasswordToken
    self.declinedReason = declinedReason
    self.oauthClientId = oauthClientId
    self.oauthClientSecret = oauthClientSecret
    self.requestCreationTime = requestCreationTime

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == 1:
        if ftype == TType.STRING:
          self.gatewayId = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 2:
        if ftype == TType.I32:
          self.gatewayApprovalStatus = iprot.readI32()
        else:
          iprot.skip(ftype)
      elif fid == 3:
        if ftype == TType.STRING:
          self.gatewayName = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 4:
        if ftype == TType.STRING:
          self.domain = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 5:
        if ftype == TType.STRING:
          self.emailAddress = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 6:
        if ftype == TType.STRING:
          self.gatewayAcronym = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 7:
        if ftype == TType.STRING:
          self.gatewayURL = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 8:
        if ftype == TType.STRING:
          self.gatewayPublicAbstract = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 9:
        if ftype == TType.STRING:
          self.reviewProposalDescription = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 10:
        if ftype == TType.STRING:
          self.gatewayAdminFirstName = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 11:
        if ftype == TType.STRING:
          self.gatewayAdminLastName = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 12:
        if ftype == TType.STRING:
          self.gatewayAdminEmail = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 13:
        if ftype == TType.STRING:
          self.identityServerUserName = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 14:
        if ftype == TType.STRING:
          self.identityServerPasswordToken = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 15:
        if ftype == TType.STRING:
          self.declinedReason = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 16:
        if ftype == TType.STRING:
          self.oauthClientId = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 17:
        if ftype == TType.STRING:
          self.oauthClientSecret = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 18:
        if ftype == TType.I64:
          self.requestCreationTime = iprot.readI64()
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('Gateway')
    if self.gatewayId is not None:
      oprot.writeFieldBegin('gatewayId', TType.STRING, 1)
      oprot.writeString(self.gatewayId)
      oprot.writeFieldEnd()
    if self.gatewayApprovalStatus is not None:
      oprot.writeFieldBegin('gatewayApprovalStatus', TType.I32, 2)
      oprot.writeI32(self.gatewayApprovalStatus)
      oprot.writeFieldEnd()
    if self.gatewayName is not None:
      oprot.writeFieldBegin('gatewayName', TType.STRING, 3)
      oprot.writeString(self.gatewayName)
      oprot.writeFieldEnd()
    if self.domain is not None:
      oprot.writeFieldBegin('domain', TType.STRING, 4)
      oprot.writeString(self.domain)
      oprot.writeFieldEnd()
    if self.emailAddress is not None:
      oprot.writeFieldBegin('emailAddress', TType.STRING, 5)
      oprot.writeString(self.emailAddress)
      oprot.writeFieldEnd()
    if self.gatewayAcronym is not None:
      oprot.writeFieldBegin('gatewayAcronym', TType.STRING, 6)
      oprot.writeString(self.gatewayAcronym)
      oprot.writeFieldEnd()
    if self.gatewayURL is not None:
      oprot.writeFieldBegin('gatewayURL', TType.STRING, 7)
      oprot.writeString(self.gatewayURL)
      oprot.writeFieldEnd()
    if self.gatewayPublicAbstract is not None:
      oprot.writeFieldBegin('gatewayPublicAbstract', TType.STRING, 8)
      oprot.writeString(self.gatewayPublicAbstract)
      oprot.writeFieldEnd()
    if self.reviewProposalDescription is not None:
      oprot.writeFieldBegin('reviewProposalDescription', TType.STRING, 9)
      oprot.writeString(self.reviewProposalDescription)
      oprot.writeFieldEnd()
    if self.gatewayAdminFirstName is not None:
      oprot.writeFieldBegin('gatewayAdminFirstName', TType.STRING, 10)
      oprot.writeString(self.gatewayAdminFirstName)
      oprot.writeFieldEnd()
    if self.gatewayAdminLastName is not None:
      oprot.writeFieldBegin('gatewayAdminLastName', TType.STRING, 11)
      oprot.writeString(self.gatewayAdminLastName)
      oprot.writeFieldEnd()
    if self.gatewayAdminEmail is not None:
      oprot.writeFieldBegin('gatewayAdminEmail', TType.STRING, 12)
      oprot.writeString(self.gatewayAdminEmail)
      oprot.writeFieldEnd()
    if self.identityServerUserName is not None:
      oprot.writeFieldBegin('identityServerUserName', TType.STRING, 13)
      oprot.writeString(self.identityServerUserName)
      oprot.writeFieldEnd()
    if self.identityServerPasswordToken is not None:
      oprot.writeFieldBegin('identityServerPasswordToken', TType.STRING, 14)
      oprot.writeString(self.identityServerPasswordToken)
      oprot.writeFieldEnd()
    if self.declinedReason is not None:
      oprot.writeFieldBegin('declinedReason', TType.STRING, 15)
      oprot.writeString(self.declinedReason)
      oprot.writeFieldEnd()
    if self.oauthClientId is not None:
      oprot.writeFieldBegin('oauthClientId', TType.STRING, 16)
      oprot.writeString(self.oauthClientId)
      oprot.writeFieldEnd()
    if self.oauthClientSecret is not None:
      oprot.writeFieldBegin('oauthClientSecret', TType.STRING, 17)
      oprot.writeString(self.oauthClientSecret)
      oprot.writeFieldEnd()
    if self.requestCreationTime is not None:
      oprot.writeFieldBegin('requestCreationTime', TType.I64, 18)
      oprot.writeI64(self.requestCreationTime)
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def validate(self):
    if self.gatewayId is None:
      raise TProtocol.TProtocolException(message='Required field gatewayId is unset!')
    if self.gatewayApprovalStatus is None:
      raise TProtocol.TProtocolException(message='Required field gatewayApprovalStatus is unset!')
    return


  def __hash__(self):
    value = 17
    value = (value * 31) ^ hash(self.gatewayId)
    value = (value * 31) ^ hash(self.gatewayApprovalStatus)
    value = (value * 31) ^ hash(self.gatewayName)
    value = (value * 31) ^ hash(self.domain)
    value = (value * 31) ^ hash(self.emailAddress)
    value = (value * 31) ^ hash(self.gatewayAcronym)
    value = (value * 31) ^ hash(self.gatewayURL)
    value = (value * 31) ^ hash(self.gatewayPublicAbstract)
    value = (value * 31) ^ hash(self.reviewProposalDescription)
    value = (value * 31) ^ hash(self.gatewayAdminFirstName)
    value = (value * 31) ^ hash(self.gatewayAdminLastName)
    value = (value * 31) ^ hash(self.gatewayAdminEmail)
    value = (value * 31) ^ hash(self.identityServerUserName)
    value = (value * 31) ^ hash(self.identityServerPasswordToken)
    value = (value * 31) ^ hash(self.declinedReason)
    value = (value * 31) ^ hash(self.oauthClientId)
    value = (value * 31) ^ hash(self.oauthClientSecret)
    value = (value * 31) ^ hash(self.requestCreationTime)
    return value

  def __repr__(self):
    L = ['%s=%r' % (key, value)
      for key, value in self.__dict__.iteritems()]
    return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)

class Notification:
  """
  Attributes:
   - notificationId
   - gatewayId
   - title
   - notificationMessage
   - creationTime
   - publishedTime
   - expirationTime
   - priority
  """

  thrift_spec = (
    None, # 0
    (1, TType.STRING, 'notificationId', None, None, ), # 1
    (2, TType.STRING, 'gatewayId', None, None, ), # 2
    (3, TType.STRING, 'title', None, None, ), # 3
    (4, TType.STRING, 'notificationMessage', None, None, ), # 4
    (5, TType.I64, 'creationTime', None, None, ), # 5
    (6, TType.I64, 'publishedTime', None, None, ), # 6
    (7, TType.I64, 'expirationTime', None, None, ), # 7
    (8, TType.I32, 'priority', None, None, ), # 8
  )

  def __init__(self, notificationId=None, gatewayId=None, title=None, notificationMessage=None, creationTime=None, publishedTime=None, expirationTime=None, priority=None,):
    self.notificationId = notificationId
    self.gatewayId = gatewayId
    self.title = title
    self.notificationMessage = notificationMessage
    self.creationTime = creationTime
    self.publishedTime = publishedTime
    self.expirationTime = expirationTime
    self.priority = priority

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == 1:
        if ftype == TType.STRING:
          self.notificationId = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 2:
        if ftype == TType.STRING:
          self.gatewayId = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 3:
        if ftype == TType.STRING:
          self.title = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 4:
        if ftype == TType.STRING:
          self.notificationMessage = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 5:
        if ftype == TType.I64:
          self.creationTime = iprot.readI64()
        else:
          iprot.skip(ftype)
      elif fid == 6:
        if ftype == TType.I64:
          self.publishedTime = iprot.readI64()
        else:
          iprot.skip(ftype)
      elif fid == 7:
        if ftype == TType.I64:
          self.expirationTime = iprot.readI64()
        else:
          iprot.skip(ftype)
      elif fid == 8:
        if ftype == TType.I32:
          self.priority = iprot.readI32()
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('Notification')
    if self.notificationId is not None:
      oprot.writeFieldBegin('notificationId', TType.STRING, 1)
      oprot.writeString(self.notificationId)
      oprot.writeFieldEnd()
    if self.gatewayId is not None:
      oprot.writeFieldBegin('gatewayId', TType.STRING, 2)
      oprot.writeString(self.gatewayId)
      oprot.writeFieldEnd()
    if self.title is not None:
      oprot.writeFieldBegin('title', TType.STRING, 3)
      oprot.writeString(self.title)
      oprot.writeFieldEnd()
    if self.notificationMessage is not None:
      oprot.writeFieldBegin('notificationMessage', TType.STRING, 4)
      oprot.writeString(self.notificationMessage)
      oprot.writeFieldEnd()
    if self.creationTime is not None:
      oprot.writeFieldBegin('creationTime', TType.I64, 5)
      oprot.writeI64(self.creationTime)
      oprot.writeFieldEnd()
    if self.publishedTime is not None:
      oprot.writeFieldBegin('publishedTime', TType.I64, 6)
      oprot.writeI64(self.publishedTime)
      oprot.writeFieldEnd()
    if self.expirationTime is not None:
      oprot.writeFieldBegin('expirationTime', TType.I64, 7)
      oprot.writeI64(self.expirationTime)
      oprot.writeFieldEnd()
    if self.priority is not None:
      oprot.writeFieldBegin('priority', TType.I32, 8)
      oprot.writeI32(self.priority)
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def validate(self):
    if self.gatewayId is None:
      raise TProtocol.TProtocolException(message='Required field gatewayId is unset!')
    if self.title is None:
      raise TProtocol.TProtocolException(message='Required field title is unset!')
    if self.notificationMessage is None:
      raise TProtocol.TProtocolException(message='Required field notificationMessage is unset!')
    return


  def __hash__(self):
    value = 17
    value = (value * 31) ^ hash(self.notificationId)
    value = (value * 31) ^ hash(self.gatewayId)
    value = (value * 31) ^ hash(self.title)
    value = (value * 31) ^ hash(self.notificationMessage)
    value = (value * 31) ^ hash(self.creationTime)
    value = (value * 31) ^ hash(self.publishedTime)
    value = (value * 31) ^ hash(self.expirationTime)
    value = (value * 31) ^ hash(self.priority)
    return value

  def __repr__(self):
    L = ['%s=%r' % (key, value)
      for key, value in self.__dict__.iteritems()]
    return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)
